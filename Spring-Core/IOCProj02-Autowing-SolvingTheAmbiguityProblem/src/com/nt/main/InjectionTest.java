package com.nt.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;

public class InjectionTest {

	public static void main(String[] args) {
		System.out.println("SetterInjectionTest.main()(start)");
		//create the IOC container
		FileSystemXmlApplicationContext ctx=
				      new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		//get  Target spring bean class obj
		Object obj=ctx.getBean("wmg");
		//typecasting
		WishMessageGenerator generator=(WishMessageGenerator)obj;
		//invoke the b.method
		String result=generator.showWishMessage("raja");
		//display the result
		System.out.println(result);
		
		//close container
		ctx.close();
		
		System.out.println("SetterInjectionTest.main()(end)");

	}

}
