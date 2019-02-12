package com.teradata.kafka.consumer;


import org.junit.Test;

import com.teradata.kafka.connector.TeradataDBConnector;
import com.teradata.kafka.producer.AvroProducer;

public class TestKafkaAvroConsumer {
	
	//@Test
	public void testNRecords() {
		
		TeradataDBConnector conn =new TeradataDBConnector();
		conn.cleanTable();
		System.out.println("Producer starting...");
		AvroProducer producer = new AvroProducer();
		producer.produce(1000, "schema1.json");
		System.out.println("Producer done");
		
	}
	
	//@Test
	public void getRecords() {
		
		TeradataDBConnector conn =new TeradataDBConnector();
		conn.readFromDB();
		
	}
	
	@Test
	public void getRecordsCount() {
		
		TeradataDBConnector conn =new TeradataDBConnector();
		conn.getRecordCount();
		
	}
	
	
	//@Test
	public void cleanDB() {
		
		TeradataDBConnector conn =new TeradataDBConnector();
		conn.cleanTable();
		
	}
	
}
