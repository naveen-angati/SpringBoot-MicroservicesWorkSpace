//BankOperationsService.java
package com.nt.service;

import org.springframework.stereotype.Component;

//@Component("bankService")
public  class BankOperationsService {
	
	
	public static  double  calculateIntrestAmount(double pamt, double rate, double time) {
		System.out.println("BankOperationsService.calculateIntrestAmount()(compound Intrest)");
		return   (pamt*Math.pow(1+rate/100,time))- pamt;
		
	}

}
