package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJmsProj01PtpSenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj01PtpSenderAppApplication.class, args);
	}

}
