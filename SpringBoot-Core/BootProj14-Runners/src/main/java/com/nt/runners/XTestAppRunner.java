package com.nt.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class XTestAppRunner implements ApplicationRunner,Ordered{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("XTestAppRunner.run()");
		System.out.println("option args::"+args.getNonOptionArgs());
		System.out.println("optional arg names and  values ::");
		for(String  name:args.getOptionNames()) {
			System.out.println(name+" ...."+args.getOptionValues(name));
		}
		System.out.println("----------------------");

	}

	@Override
	public int getOrder() {
		return -4;
	}

}
