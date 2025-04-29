package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootMsProj09SpringBootActuatorsApplication {
	
	
	@Bean(name="ldt")
	public  LocalDateTime createLDT() {
		return   LocalDateTime.now();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj09SpringBootActuatorsApplication.class, args);
	}

}
