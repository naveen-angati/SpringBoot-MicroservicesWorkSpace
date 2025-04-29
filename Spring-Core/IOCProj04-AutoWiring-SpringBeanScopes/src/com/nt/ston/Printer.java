//Printer.java 
package com.nt.ston;

public class Printer {
	  //reference variable of the class
	private static  Printer INSTANCE;
	
	
	//private constructor
	private Printer() {
		System.out.println("0-param constructor");
	}
	
	//static factory method having singleton logic
	public static   Printer  getInstance() {
		System.out.println("Printer.getInstance()");
		         //singleton logic with minimum standards
	          if(INSTANCE==null)	
	        	    INSTANCE=new Printer();
	          
	          return  INSTANCE;
	}

}
