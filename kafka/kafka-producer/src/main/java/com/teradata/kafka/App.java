package com.teradata.kafka;

import com.teradata.kafka.producer.AvroProducer;

/**
 * Hello world!
 *
 */
public class App {
	
	public static String topicName = "testTopic";
	public static String kafkaBroker = "54.213.148.161:9092";//"localhost:9092";
	//"54.213.148.161:9092";
	
	public static void main(String[] args) {
		
		String fileName = "/home/ravi/work/codebase/learning/myRepository/teradata-kafka-connector/kafka-producer/src/main/java/com/teradata/kafka/producer/schema1.json";
		if(null != args[0] && !args[0].isEmpty()) {
			fileName = args[0];
			System.out.println("file path:" + args[0]);
		}
		long msgCounter = 1000;
		if(null != args[1] && !args[1].isEmpty()) {
			msgCounter = Long.parseLong(args[1]);
			System.out.println("messageCounter:" + args[1]);
		}
		System.out.println("sending message to :" + kafkaBroker);
		System.out.println("Producer starting...");
		AvroProducer producer = new AvroProducer();
		producer.produce(msgCounter, fileName, kafkaBroker);
		System.out.println("Producer done");
	}
}
