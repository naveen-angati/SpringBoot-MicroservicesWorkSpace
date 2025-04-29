package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class  BTestCmdLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BTestCmdLineRunner.run()");
		System.out.println("command args are :::"+Arrays.toString(args));
		int a=10;
		System.out.println("Square value ::"+(a*a));
		System.out.println("----------------------");

	}

}
