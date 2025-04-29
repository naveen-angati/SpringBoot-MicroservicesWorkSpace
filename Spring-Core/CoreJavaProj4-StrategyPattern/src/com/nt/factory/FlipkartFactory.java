//FlipkartFactory.java (Factory Pattern class)
package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;

public class FlipkartFactory {
	
	 //static factory method  having factory pattern logic
	public  static   Flipkart  getInstance(String courierType) {
		      //create Dependent class obj
		      Courier courier=null;
		      if(courierType.equalsIgnoreCase("dtdc"))
		    	  courier=new DTDC();
		      else if(courierType.equalsIgnoreCase("blueDart"))
		    	  courier=new BlueDart();
		      else
		    	  throw new IllegalArgumentException("invalid courier type");
		      //create target class obj
		       Flipkart fpkt=new Flipkart();
		       //assign  dependent class object to target class obj
		       fpkt.setCourier(courier);
		       
		       return fpkt;
	}

}
