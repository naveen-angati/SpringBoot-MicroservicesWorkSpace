package com.nt;

import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
@EnableEurekaClient
public class BootMsProj15PaymentServiceMsTargetMsZipkinSluethApplication {
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj15PaymentServiceMsTargetMsZipkinSluethApplication.class, args);
	}

}
