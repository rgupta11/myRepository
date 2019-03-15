package com.teradata.cloudmigration.nparcProxy.activemq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.teradata.cloudmigration.nparcProxy.data.HttpRequestData;

@Component
//@Service
//@Scope(value="prototype")
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	@Qualifier("sourceQueue")
	private Queue sourceQueue;
	
	@Autowired
	@Qualifier("targetQueue")
	private Queue targetQueue;
	
	@Autowired
	private Topic responseTopic;
	
	public void sendToSource(HttpRequestData data) {
		try {
			jmsMessagingTemplate.convertAndSend(sourceQueue, data.toJson());
			//jmsMessagingTemplate.convertAndSend(responseTopic, data.toJson());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendToTarget(HttpRequestData msg) {
		this.jmsMessagingTemplate.convertAndSend(targetQueue, msg);
	}

}
