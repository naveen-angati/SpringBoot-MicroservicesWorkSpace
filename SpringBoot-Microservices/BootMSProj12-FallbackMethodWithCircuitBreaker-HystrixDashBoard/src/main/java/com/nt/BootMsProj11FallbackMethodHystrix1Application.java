package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class BootMsProj11FallbackMethodHystrix1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj11FallbackMethodHystrix1Application.class, args);
	}

}
