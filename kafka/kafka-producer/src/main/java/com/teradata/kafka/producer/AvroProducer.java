package com.teradata.kafka.producer;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericData.Record;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;

import com.teradata.kafka.App;

import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;

public class AvroProducer {

	public void produce(long msgCounter, String fileName, String kafkaBroker) {

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		/*if (fileName.contains("schema_employee.json")) {
			props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaEmployee");
		} else {*/
			props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaPOC");
		//}
		props.setProperty("value.subject.name.strategy", TopicRecordNameStrategy.class.getName());
		props.put("schema.registry.url", "http://localhost:8081");
		System.out.println("Properties:" + props);
		KafkaProducer producer = new KafkaProducer(props);
		Schema.Parser parser = new Schema.Parser();

		try {

			// Schema schema = parser.parse(getClass().getResourceAsStream(fileName));
			Schema schema = parser.parse(new File(fileName));
			if (fileName.contains("schema_employee.json")) {
				produceEmployeeRecords(msgCounter, schema, producer);
			} else {
				for (int i = 0; i < msgCounter; i++) {
					GenericRecord avroRecord = new GenericData.Record(schema);
					if (i == 0) {
						avroRecord.put("f1", "first");
					} else if (i == (msgCounter - 1)) {
						avroRecord.put("f1", "last");
					} else {
						avroRecord.put("f1", "value-" + i);
					}
					ProducerRecord<Object, Object> record = new ProducerRecord<>(App.topicName, avroRecord);
					producer.send(record);
					System.out.println(record.value());
				}
			}
		} catch (SerializationException e) {
			e.printStackTrace();
			System.out.println("Error in Serialization");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in readinf schema file");
		} finally {
			producer.flush();
			producer.close();
		}

	}

	private void produceEmployeeRecords(long msgCounter, Schema schema, KafkaProducer producer) throws SerializationException{
		
		for (int i = 0; i < msgCounter; i++) {
			
			
			GenericRecordBuilder recordBuilder = new GenericRecordBuilder(schema);
			recordBuilder.set("firstName", "firstName-" + i);
			recordBuilder.set("nickName", "nickName-" + i);
			recordBuilder.set("lastName", "lastName-" + i);
			recordBuilder.set("age", i);
			recordBuilder.set("emails", i + "-abc.xxmail.com");
			recordBuilder.set("status", "SALARY");
			Record empRecord = recordBuilder.build();
			ProducerRecord<Object, Object> record = new ProducerRecord<>(App.topicName, empRecord);
			producer.send(record);
			System.out.println(record.value());
		}
		
	}

}