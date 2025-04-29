//SeasonFinder.java (target class)
package com.nt.sbeans;

import java.time.LocalDate;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	private static Logger logger=LoggerFactory.getLogger(SeasonFinder.class);
	//bean property
	@Autowired
	private   LocalDate   ldt;
	
	
	//b.method
	  public  String  findSeason() {
		  logger.trace("start of the method");
		   //get current month
		  int month=ldt.getMonthValue();
		  
		  logger.debug("end of the method");
		  //show seasos name
		  if(month>=3 && month<=6)
			  return "Summer Season";
		  else if(month>=7 && month<=10)
			   return "Rainy Season";
		  else
			  return "Winter Season";
			  
		 
	  }
	
	

}
