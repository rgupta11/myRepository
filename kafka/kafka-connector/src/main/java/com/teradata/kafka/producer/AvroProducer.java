package com.teradata.kafka.producer;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;

import com.teradata.kafka.App;

public class AvroProducer {

	public void produce(int counter, String fileName) {

		Properties props = new Properties();
		//props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "54.213.148.161:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaPOC");
		props.put("schema.registry.url", "http://localhost:8081");
		KafkaProducer producer = new KafkaProducer(props);
		// String key = "key1";
		/*String userSchema = "{\"type\":\"record\"," + "\"name\":\"myrecord\","
				+ "\"fields\":[{\"name\":\"f1\",\"type\":\"string\"}]}";*/
		Schema.Parser parser = new Schema.Parser();
		
		try {
			
			Schema schema = parser.parse(getClass().getResourceAsStream(fileName));
			for (int i = 0; i < counter; i++) {
				GenericRecord avroRecord = new GenericData.Record(schema);
				if(i == 0) {
					avroRecord.put("f1", "first");
				}else if(i == (counter - 1)) {
					avroRecord.put("f1", "last");
				}else {
					avroRecord.put("f1", "value-" + i);
				}
				ProducerRecord<Object, Object> record = new ProducerRecord<>(App.topicName, avroRecord);
				producer.send(record);
				System.out.println(record.value());
			}
		} catch (SerializationException e) {
			System.out.println("Error in Serialization");
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in readinf schema file");
		} finally {
			producer.flush();
			producer.close();
		}

	}

}