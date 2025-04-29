package com.nt.main;

import java.time.LocalDateTime;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;
import com.nt.ston.Printer;

public class InjectionTest {

	public static void main(String[] args) {
		System.out.println("SetterInjectionTest.main()(start)");
		// create the IOC container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/com/nt/cfgs/applicationContext.xml");
		
		//get  Target spring bean class obj
		WishMessageGenerator generator1=ctx.getBean("wmg",WishMessageGenerator.class);
		WishMessageGenerator generator2=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator1.hashCode()+"  "+generator2.hashCode());
		System.out.println("generator1==generator2?"+(generator1==generator2));
		
		
		/*//invoke the b.method
		String result=generator1.showWishMessage("raja");
		String result1=generator2.showWishMessage("ramesh");
		//display the result
		System.out.println(result);
		System.out.println(result1);*/
		
		
		
	/*	System.out.println("=============================");
		
		LocalDateTime dt1=ctx.getBean("ldt",LocalDateTime.class);
		LocalDateTime dt2=ctx.getBean("ldt",LocalDateTime.class);
		System.out.println(dt1.hashCode()+"   "+dt2.hashCode());
		System.out.println("(dt1== dt2?)"+(dt1==dt2));
		
		System.out.println("----------------------------------------");
		
		LocalDateTime dt3=ctx.getBean("ldt1",LocalDateTime.class);
		LocalDateTime dt4=ctx.getBean("ldt1",LocalDateTime.class);
		System.out.println(dt3.hashCode()+"   "+dt4.hashCode());
		System.out.println("(dt3== dt4?)"+(dt3==dt4)); 
		
		System.out.println("===================================");
		Printer p1=ctx.getBean("p1",Printer.class);
		Printer p2=ctx.getBean("p1",Printer.class);
		System.out.println(p1.hashCode()+"  "+p2.hashCode());
		System.out.println("p1==p2?"+(p1==p2));
		
		Printer p3=ctx.getBean("p2",Printer.class);
		Printer p4=ctx.getBean("p2",Printer.class);
		System.out.println(p3.hashCode()+"  "+p4.hashCode());
		System.out.println("p3==p4?"+(p3==p4));
		
		
		
		//close container
		ctx.close();
		*/
		System.out.println("SetterInjectionTest.main()(end)");

	}

}
