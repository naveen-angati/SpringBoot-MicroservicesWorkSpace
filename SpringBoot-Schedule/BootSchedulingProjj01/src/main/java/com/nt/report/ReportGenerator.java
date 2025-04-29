//ReportGenerator.java
package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
	
	//@Scheduled(initialDelay = 2000, fixedDelay = 3000)
	//@Scheduled( fixedDelay = 3000)
	//@Scheduled( fixedDelayString = "3000")
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedRate = 10000,fixedDelay = 3000)
	//@Scheduled(cron = "15 * *  * * *")
	//@Scheduled(cron = " 30 26 19  * * *")
	//@Scheduled(cron = " 0 34,35 19  * * *")
	//@Scheduled(cron = " 10 39-41 19  * * *")
	//@Scheduled(cron = " *  56 19  * * *")
	//@Scheduled(cron = " 10  * 20  * * *")
	//@Scheduled(cron = " 0  6  20  * * FRI")
	//@Scheduled(cron = " 0/30    * *  * * *")
	//@Scheduled(cron = " 0   21/2 20  * * *")
	//@Scheduled(cron="0/5 42/2 19 * * *")
	  // @Scheduled(cron="@hourly")
	@Scheduled(cron="0 15 20 L-11 * *")
	public void showReport1() {
	
		System.out.println("report1 generated on ::"+new Date());
	
	}//method
	
	/*	@Scheduled(fixedRate = 10000)
		public void showReport2() {
			System.out.println("Report2 Thread name ::"+Thread.currentThread().getName());
			System.out.println("report2 generated on(strat) ::"+new Date());
		
			  try {
				  Thread.sleep(15000);
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
			  System.out.println("report2 generated on(end) ::"+new Date());
		}//method
	*/
}
