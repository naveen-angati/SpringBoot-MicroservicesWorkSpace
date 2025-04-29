package com.nt.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;



public class MessageSenderApp {

	public static void main(String[] args) {
		//create kafka properties  for  establishing the connetion
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		//create kafka producer object
		KafkaProducer< String, String> producer=new KafkaProducer<String, String>(props);
		//  create Kakfa ProducerRecord object (topic name , message)
		ProducerRecord<String, String> record=new ProducerRecord<String, String>("nt-ktpc1", "welcome to apache kafka");
		//send the record
		producer.send(record);
		//flush the message
		producer.flush();
		//close the connetion
		producer.close();
		System.out.println("message is sent");
		

	}

}
