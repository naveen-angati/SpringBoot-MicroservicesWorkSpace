package com.nt.core;

public class LAMDATest {

	public static void main(String[] args) {
		Arithemetic ar=(int a,int b)->{ return  a+b; };
		         System.out.println(ar.add(10,20));
		         System.out.println("____________");
		         Arithemetic ar1=(a, b)->   a+b; 
		         System.out.println(ar1.add(10,20));
		         
		  Arithemetic ar2=Integer::sum;
		  System.out.println(ar2.add(10, 20));

	}

}
