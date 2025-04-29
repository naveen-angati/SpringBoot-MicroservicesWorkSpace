//Test.java (java class)
package com.nt.comp;

public class Test {
	
	private int a,b;
	
	public Test() {
		System.out.println("Test:0-param constructor");
	}
	
	public  Test(int x,int y) {
		System.out.println("Test:2-param constructor");
		this.a=x;
		this.b=y;
	}
	
	//toString
	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}


}
