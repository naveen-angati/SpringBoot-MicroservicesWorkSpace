package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProjj01Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProjj01Application.class, args);
		System.out.println("BootSchedulingProjj01Application.main() Thread name::"+Thread.currentThread().getName());
		System.out.println("App started at::"+new Date());
	}

}
