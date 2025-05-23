package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // To make it registrable,discoverable from the EurekaServer
public class BootMsProj05PaymentServiceMsProviderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05PaymentServiceMsProviderAppApplication.class, args);
	}

}
