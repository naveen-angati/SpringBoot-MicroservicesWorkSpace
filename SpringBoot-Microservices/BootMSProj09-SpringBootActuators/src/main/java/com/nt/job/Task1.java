package com.nt.job;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task1 {
	
	@Scheduled(initialDelay = 2000,fixedDelay = 3000)
	public void showReport() {
		System.out.println("report on::"+new Date());
	}

}
