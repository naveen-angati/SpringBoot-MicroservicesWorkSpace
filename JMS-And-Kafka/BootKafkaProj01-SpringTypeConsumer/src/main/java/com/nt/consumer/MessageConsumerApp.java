package com.nt.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;



public class MessageConsumerApp {

	public static void main(String[] args) {
		//create kafka properties  for  establishing the connetion
		Properties props=new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1");
		
		//create kafka producer object
		KafkaConsumer< String, String> consumer=new KafkaConsumer<String, String>(props);
		
		//subscrible  message broker(s)
		consumer.subscribe(Arrays.asList("nt-ktpc1"));
		
		// Do polling
		while(true) {
			ConsumerRecords< String , String> records=consumer.poll(Duration.ofMillis(1000));
			for(ConsumerRecord<String,String> record:records) {
				  System.out.println(record.key()+" ...."+record.value());
			}
		}
		
		
		

	}

}
