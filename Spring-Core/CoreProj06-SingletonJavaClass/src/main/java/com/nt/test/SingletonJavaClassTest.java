// SingletonJavaClassTest.java
package com.nt.test;

import com.nt.ston.Printer;

public class SingletonJavaClassTest {

	public static void main(String[] args) {
		// Get Printer Object
		Printer p1=Printer.getInstance();
		Printer p2=Printer.getInstance();
		Printer p3=Printer.getInstance();
		System.out.println(p1.hashCode()+"  "+p2.hashCode()+" "+p3.hashCode());  //gives same hash code
		System.out.println( "p1==p2?"+(p1==p2));  //gives true
		System.out.println( "p2==p3?"+(p2==p3));  //give true
		

	}

}
