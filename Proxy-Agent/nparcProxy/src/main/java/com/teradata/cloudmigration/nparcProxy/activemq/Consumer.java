package com.teradata.cloudmigration.nparcProxy.activemq;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.teradata.cloudmigration.nparcProxy.utils.ProxyUtils;

@Component
//@Service
//@Scope(value="prototype")
public class Consumer {
	
	
	private AtomicInteger durableCounter = new AtomicInteger();
	public static ConcurrentHashMap<String, JSONObject> messageMap = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<String, JSONObject> messageLogMap = new ConcurrentHashMap<>();

	public static enum ResponseMandatoryFields {

		MIGRATION_ID("migrationId"), BODY("body"), STATUS_CODE("statusCode");

		private final String name;

		ResponseMandatoryFields(String name) {
			this.name = name;
		}

		String getName() {
			return name;
		}
	}

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	@Qualifier("sourceQueue")
	private Queue sourceQueue;

	@Autowired
	@Qualifier("targetQueue")
	private Queue targetQueue;

	@Autowired
	@Qualifier("responseQueue")
	private Queue responseQueue;

	@Autowired
	private Topic responseTopic;

	/*
	 * @Autowired private MessageConverter messageConverter;
	 */

	/*
	 * @JmsListener(destination = "source.queue") public void
	 * receiveSourceQueue(String text) { logger.info("Consumer source data :" +
	 * text); }
	 * 
	 * @JmsListener(destination = "target.queue") public void
	 * receiveTargetQueue(String text) { logger.info("Consumer taget data:" + text);
	 * }
	 */

	@JmsListener(destination = "response.topic")
	public void receiveTargetTopic(String message) throws ParseException, IOException, JSONException {
		
		durableCounter.incrementAndGet();
		logger.info("Consumer response Q data :" + message);
		JSONObject data = ProxyUtils.getJson(message);
		//messageMap.get(data.get("migrationId").toString())
		messageMap.putIfAbsent(data.get("migrationId").toString(), data);
		messageLogMap.putIfAbsent(data.get("migrationId").toString(), data);
		/*int statusCode = data.getInt("statusCode");
		String encodedHeaders = data.get("headers").toString();
		String encodedBody = data.get("body").toString();
		String migrationId = data.get("migrationId").toString();

		String headers = ProxyUtils.decodeBase64(encodedHeaders);
		String body = ProxyUtils.decodeBase64(encodedBody);*/

		logger.info("---durableCounter---" + durableCounter.get());
		
	}
	/*
	 * @JmsListener(destination = "response.queue") public void
	 * receiveSourceQueue(String message) throws JsonParseException,
	 * JsonMappingException, IOException { logger.info("Consumer response Q data :"
	 * + message); boolean isMigrationIdFound = false;
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); HttpResponseData resp = null; try {
	 * resp = mapper.readValue(message, HttpResponseData.class); if
	 * (resp.getMigrationId().equals("migrationId1")) {
	 * logger.info("Mesage found queue...."); }else {
	 * logger.info("Useless Mesage queue...."); } }catch(Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */

	private HttpServletResponse fillHeaders(JSONObject data, HttpServletResponse response) throws ParseException, JSONException, IOException {
		
		String headers = "";
		if (null != data.get("headers") && data.get("headers") != "") {
			logger.debug("Headers found -{}", data.get("headers"));
			String encodedHeaders = data.get("headers").toString();
			headers = ProxyUtils.decodeBase64(encodedHeaders);
			JSONObject jsonHeaders = ProxyUtils.getJson(headers);
			Iterator keys = jsonHeaders.keys();
			while(keys.hasNext()) {
				String headerKey = keys.next().toString();
				String headerValue = jsonHeaders.getString(headerKey);
				response.setHeader(headerKey, headerValue);
				logger.debug("Header {} -- {}", headerKey, headerValue);
			}
			
		} else {
			logger.warn("No headers found in response from Agent.");
		}
		return response;
	}
	
	public HttpServletResponse fillResponseFromMessage(JSONObject data, HttpServletResponse response) throws JSONException, IOException {

		int statusCode = data.getInt(ResponseMandatoryFields.STATUS_CODE.getName());
		String encodedBody = data.get(ResponseMandatoryFields.BODY.getName()).toString();
		String migrationId = data.get(ResponseMandatoryFields.MIGRATION_ID.getName()).toString();
		String body = ProxyUtils.decodeBase64(encodedBody);
		
		response = fillHeaders(data, response);
		response.setHeader("X-Migration-Header", migrationId);
		response.setStatus(statusCode);
		response.getWriter().append(body);
		return response;
	}

	public boolean validateMigrationId(String migId, JSONObject data) throws JSONException {
		
		if(null != data.get("migrationId") && data.get("migrationId") != "") {
			String migrationId = data.get("migrationId").toString();
			if(migId.equals(migrationId)) {
				return true;
			}
		}else {
			logger.warn("No migration Id found in message from agent. Ignoring this message and waiting for other message");
		}
		return false;
	}

	/*public JSONObject receiveResponse()
			throws JMSException, JsonParseException, JsonMappingException, IOException, JSONException {

		Message<?> message = null;
		message = jmsMessagingTemplate.receive(responseTopic);
		logger.info("----------------------------------------------------");
		logger.info("Message--{}----:{}", responseTopic.getTopicName(), message);
		logger.info("Message-Payload---{}----:{}", responseTopic.getTopicName(), message.getPayload().toString());
		return ProxyUtils.getJson(message.getPayload().toString());

	}*/



	/*
	 * ActiveMQConnectionFactory connectionFactory = new
	 * ActiveMQConnectionFactory();
	 * connectionFactory.setBrokerURL("vm://embedded");//(
	 * "tcp://192.168.56.101:61616"); connectionFactory.setUserName("admin");
	 * connectionFactory.setPassword("admin"); Connection connection =
	 * connectionFactory.createConnection(); connection.start(); Session session =
	 * connection.createSession(false, Session.AUTO_ACKNOWLEDGE); Destination
	 * destination = session.createQueue(sourceQueue.getQueueName());
	 * MessageConsumer consumer = session.createConsumer(destination); return
	 * consumer;
	 */



}
