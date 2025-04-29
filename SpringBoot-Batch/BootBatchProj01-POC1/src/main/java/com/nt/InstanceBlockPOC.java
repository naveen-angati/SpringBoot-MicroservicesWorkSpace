package com.nt;
class Test{
	Test(){
		System.out.println("Test:: 0-param constructor");
	}
	public void m1() {
		System.out.println("Test.m1()");
	}
}

public class InstanceBlockPOC {

	public static void main(String[] args) {
		Test t= new Test();
		 t.m1();
		 System.out.println("t obj clas sname ::"+t.getClass());
		 System.out.println("-----------------------------");
		 Test t1=new Test() { };
		 t1.m1();
		 System.out.println("t1 obj clas sname ::"+t1.getClass());
		 System.out.println("-----------------------------");
		 
		 Test t2=new Test() {
			 {
				 m1();
			 }
		 };
		 System.out.println("t2 obj clas sname ::"+t2.getClass());
		 System.out.println("-----------------------------");

	}//main

}//class
