package com.teradata.cloudmigration.nparcProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import com.teradata.cloudmigration.nparcProxy.activemq.Consumer;
import com.teradata.cloudmigration.nparcProxy.activemq.Producer;
import com.teradata.cloudmigration.nparcProxy.data.HttpRequestData;

@SpringBootApplication
@EnableAutoConfiguration
public class NparcProxyApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(NparcProxyApplication.class);
	
	private AtomicInteger producerCounter = new AtomicInteger();
	private AtomicInteger consumerCounter = new AtomicInteger();
	private Map<String, String> map = new ConcurrentHashMap<>();
	private List list = new ArrayList<>();

	@Autowired
	private Producer producer;

	@Autowired
	private Consumer topicConsumer;

	@Autowired
	private HttpRequestData req;	
	
	
	private void fillRequest(HttpServletRequest request, String uuid) throws IOException {
		
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, String> headers = new HashMap<>();
		while (headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			//TODO look into headers
			if(nextElement.equalsIgnoreCase("accept-encoding")) {
				headers.put(nextElement, "*");
			}else {
				if(!nextElement.equalsIgnoreCase("content-length")) {
					headers.put(nextElement, request.getHeader(nextElement));
				}
			}
		}
		logger.info("headers: {}", headers);
		// palyload
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		String payload = buffer.toString();
		logger.info("payload:" + payload);
		req.setMigrationId(uuid);
		req.setMethodName(request.getMethod());
		req.setHostName(request.getRemoteHost());
		req.setPort(request.getLocalPort());
		req.setRequestUrl(request.getRequestURL().toString());
		req.setHeaders(headers);
		req.setQueryString(request.getQueryString());
		req.setPayLoad(payload);
		
	}

	@SuppressWarnings("serial")
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet() {
			@Override
			public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

				try {
					String uuid = UUID.randomUUID().toString() + Thread.currentThread().getName();
					logger.info("UUID:" + uuid);
					fillRequest(request, uuid);
					producer.sendToSource(req);
					list.add(uuid);
					producerCounter.incrementAndGet();
					StringBuilder logDetails = new StringBuilder();
					logDetails.append("currThread-" + Thread.currentThread().getName());
					logDetails.append("| uuid-" + uuid);
					logDetails.append("| producer-" + producer);
					logDetails.append("| topicConsumer-" + topicConsumer);
					logDetails.append("| req-" + req);
					
					boolean isMigrationIdFound = false;
					JSONObject jsonData = null;
					//TODO add timeout logic
					while (!isMigrationIdFound) {
						jsonData = Consumer.messageMap.get(uuid);//topicConsumer.receiveResponse();
						//isMigrationIdFound = topicConsumer.validateMigrationId(uuid, jsonData);
						if(null != jsonData) {
							isMigrationIdFound = true;
						}
					}
					response = topicConsumer.fillResponseFromMessage(jsonData, response);
					logDetails.append(" | Received & Processed message:" + jsonData);
					consumerCounter.incrementAndGet();
					logDetails.append(" | ProducerCounter:" + producerCounter.get());
					logDetails.append(" | consumerCounter:" + consumerCounter.get());
					
					map.put(uuid, logDetails.toString());
					Consumer.messageMap.remove(uuid);
					/*logger.info("Consumer counter -------- " + consumerCounter.get());
					logger.info("Producer counter -------- " + producerCounter.get());*/
					logger.debug("------Logging details Map --------");
					for (String uuidKey : map.keySet()) {
						logger.debug("Key: " + uuidKey +  " --" + map.get(uuidKey));
					}
					logger.debug("messageMap size-----: " + topicConsumer.messageMap.size());
					
					logger.debug("List -----: " + list);
					for (String key : Consumer.messageLogMap.keySet()) {
						logger.debug(key + "-" + Consumer.messageLogMap.get(key));
					}
					
					logger.info("-------------Done with messages--------- -----------------");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
	
	private void logRequest(HttpServletRequest request) {
		
		logger.debug("----------------------------");
		logger.debug("Method:" + request.getMethod());
		logger.debug("LocalAddr:" + request.getLocalAddr());
		logger.debug("LocalPort:" + request.getLocalPort());
		logger.debug("QueryString:" + request.getQueryString());
		logger.debug("Protocol:" + request.getProtocol());
		logger.debug("Parameter:" + request.getParameterMap());
		// logger.debug("Protocol:" + request.getHeaders());
		logger.debug("RequestURL:" + request.getRequestURL());
		logger.debug("Host:" + request.getRemoteHost());
		logger.debug("Port:" + request.getRemotePort());
		logger.debug("requestURI:" + request.getRequestURI());
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NparcProxyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(NparcProxyApplication.class, args);
	}

}
