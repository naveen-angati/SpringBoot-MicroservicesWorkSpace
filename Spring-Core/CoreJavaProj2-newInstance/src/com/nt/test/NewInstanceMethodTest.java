//NewInstanceMethodTest.java (Tester class)
package com.nt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class NewInstanceMethodTest {

	public static void main(String[] args)throws Exception {
		
		//Load the Java class  (Dyamically at runtime)
		Class c=Class.forName(args[0]);
		//get all the constructor of Loaded class
		Constructor cons[]=c.getDeclaredConstructors();
		//create the objects for the Loaded class
		Object obj1=cons[0].newInstance(); //uses 0-param constructor
		System.out.println(obj1.toString());
		System.out.println("-------------------------");
		Object obj2=cons[1].newInstance(10,20); //uses 2-param constructor
		System.out.println(obj2.toString());
		
		Field fields[]=obj2.getClass().getDeclaredFields();  // gives  access to Test class all properites
		 //set acceess to private properties
		fields[0].setAccessible(true);
		fields[1].setAccessible(true);
		// set values properties
		fields[0].setInt(obj2, 2000);
		fields[1].setInt(obj2, 5000);
		System.out.println(obj2.toString());
		
		
		
		
		
	}

}
