package com.teradata.kafka;

import org.apache.commons.lang.StringUtils;

import com.teradata.kafka.connector.Connector;
import com.teradata.kafka.connector.TeradataDBConnector;
import com.teradata.kafka.consumer.GenericConsumer;
import com.teradata.kafka.consumer.KafkaAvroConsumer;

/**
 * Kafka-connector
 *
 */
public class App {
	
	public static String topicName = "testTopic";
	public static final boolean isBatchInsert = true;
	public static int batchSize = 200;

	public static void main(String[] args) {
		
		/*if(!StringUtils.isBlank(System.getProperty("topicName"))) {
			topicName = System.getProperty("topicName");
		}
		if(!StringUtils.isBlank(System.getProperty("batchSize"))) {
			batchSize = Integer.parseInt(System.getProperty("batchSize"));
		}*/
		Connector connector = new TeradataDBConnector();
		GenericConsumer consumer = new KafkaAvroConsumer();
		try {
			consumer.consume(connector);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
