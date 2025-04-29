package com.nt;

import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;



@SpringBootApplication
@EnableEurekaClient
public class BootMsProj13PaymentServiceMsTargetMsZipkinSluethApplication {
	
	
	
	@Bean
	public  Sampler createSampler() {
		return    Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj13PaymentServiceMsTargetMsZipkinSluethApplication.class, args);
	}

}
