package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class YTestAppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("YTestAppRunner.run()");
		System.out.println("option args::"+args.getNonOptionArgs());
		System.out.println("optional arg names and  values ::");
		for(String  name:args.getOptionNames()) {
			System.out.println(name+" ...."+args.getOptionValues(name));
		}
		System.out.println("----------------------");

	}

}
