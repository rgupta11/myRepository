package com.teradata.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.teradata.kafka.App;
import com.teradata.kafka.connector.Connector;
import com.teradata.kafka.connector.TeradataDBConnector;

public class KafkaAvroConsumer implements GenericConsumer {

	public void consume(Connector conn) throws Exception {
		
		TeradataDBConnector connector = (TeradataDBConnector)conn;
		
		System.out.println("Avro Consumer starting...");
		Properties props = new Properties();
		//props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "54.213.148.161:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaPOCGroup");
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "KafkaPOC");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", "http://localhost:8081");
		
		final Consumer<String, GenericRecord> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(App.topicName));
		//connector.readFromDB();
		connector.cleanTable();
		try {
			while (true) {
				ConsumerRecords<String, GenericRecord> records = consumer.poll(100);
				for (ConsumerRecord<String, GenericRecord> record : records) {
					if(App.isBatchInsert) {
						connector.batchInsert(record);
					}else {
						connector.addToDB(record);
					}
					//connector.readFromDB();
				}

			}
		} finally {
			consumer.close();
		}
		
	}

	
	
	

}
