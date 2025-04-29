package com.nt.test;

import java.util.Arrays;

import com.nt.comp.Test;

public class Property_class_Test {

	public static void main(String[] args) {
		// get java.lang.Class obj using "class" property
		Class c1=Test.class;
		System.out.println("c1 obj  data ::"+c1.toString());
		System.out.println("c1 obj class name::"+c1.getClass());
		System.out.println("super class of c1 obj  pointed  class ::"+c1.getSuperclass());
		System.out.println(" interfaces implemented by c1 obj pointed class ::"+Arrays.toString(c1.getInterfaces()));
		System.out.println(" methods of  c1 obj pointed class ::"+Arrays.toString(c1.getDeclaredMethods()));

	}

}
