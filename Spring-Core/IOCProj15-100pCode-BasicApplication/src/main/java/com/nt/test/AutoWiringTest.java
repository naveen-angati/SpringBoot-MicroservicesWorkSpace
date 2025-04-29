//AutoWiringTest.java
package com.nt.test;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class AutoWiringTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext  ctx=
				  new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("________________________");
		//get spring bean class object ref
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println("________________________");
		// invoke the b.method
		String resultMsg=generator.generateWishMessage("raja");
		System.out.println(resultMsg);
		System.out.println("________________________");
		
		LocalDateTime  dtTime=ctx.getBean("createLDT",LocalDateTime.class);
		System.out.println(dtTime);
		
		System.out.println(" spring beans count:"+ctx.getBeanDefinitionCount());
		String  beanids[]=ctx.getBeanDefinitionNames();
		System.out.println(" All bean ids "+Arrays.toString(beanids));
		System.out.println("Singleton scope spring beans are");
		for(String id:beanids) {
			    if(ctx.isSingleton(id))
			    	System.out.print(id+", ");
		}
		
		
		//close the container
		ctx.close();
		
		

	}

}
