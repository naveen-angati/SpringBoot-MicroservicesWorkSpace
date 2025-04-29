package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootKafkaProj02RestAppWithKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaProj02RestAppWithKafkaApplication.class, args);
	}

}
