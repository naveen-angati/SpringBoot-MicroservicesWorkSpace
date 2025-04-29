package com.nt.runner;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockInfo;
import com.nt.service.IStockInfoMgmt;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	@Autowired
	private IStockInfoMgmt  stockService;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
		   System.out.println(stockService.registerStock(new StockInfo(new Random().nextInt(10000),"SBI -Life","SBI",6000.0,"BSE")));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		  stockService.searchStocksByExchange("BSE").forEach(System.out::println);
		  System.out.println("_________________________");
		  stockService.searchStockByStockPriceRanage(5500.0, 6000.0).forEach(System.out::println);
		  System.out.println("_______________________");
		  System.out.println(stockService.updateStockDetailsById(9543, 8999.0, "NSE"));
		  System.out.println("_______________________");
			System.out.println(stockService.updateStockExchangeNameByPriceRange(4000.0, 7000.0, "DSE"));	
			System.out.println("_____________________");
		  
          System.out.println(stockService.saveOrUpdateStock("SBH -Life", 7900.0 , "NxSE"));
          
          System.out.println("_____________________");
		  System.out.println(stockService.removeStocksByPriceRange(5000.0, 8000.0));
	}

}
