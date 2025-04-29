package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("ciaReplacer")
public class CalculateIntrestAmountReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		  System.out.println("CalculateIntrestAmountReplacer.reimplement(-,-,-) (Simple IntrestAmount)");
		  //get target b.method arg values
		  double pamt=(double) args[0];
		  double time=(double)args[1];
		  double rate=(double)args[2];
		  //calculate simple Intrest amount
		return pamt*time*rate/100.0f;
	}

}
