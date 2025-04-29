package com.nt;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj14CommandLineRunnerApplication {
	
	@Bean
	@Order(20)
	public   CommandLineRunner  createCmdRunner1() {
		System.out.println("BootProj14CommandLineRunnerApplication.createCmdRunner1()");
		CommandLineRunner cmd=args->{
			System.out.println("Runner from main class");
			System.out.println(Arrays.toString(args));
		};
		return cmd;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(BootProj14CommandLineRunnerApplication.class, args);
	}

}
