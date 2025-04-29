//Test.java
package com.nt.comp;

public class Test {
  private int a;
  private  int b;
  
  public Test() {
	 System.out.println("Test:: 0-param constructor");
   }
  // param constructor  (alt+shift+s, o)
  public  Test(int x,int y) {
	  System.out.println("Test:: 2-param constructor");
	   this.a=x;
	   this.b=y;
  }

  
  //toString() method  (alt+shift+s,s)
  @Override
  public String toString() {
  	return "Test [a=" + a + ", b=" + b + "]";
  }
  
	
}//class

