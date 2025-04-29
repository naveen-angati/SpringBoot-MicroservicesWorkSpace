package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootBatchProj01Poc1Application {

	public static void main(String[] args)throws Exception {
		SpringApplication.run(BootBatchProj01Poc1Application.class, args);
		System.in.read();
	}

}
