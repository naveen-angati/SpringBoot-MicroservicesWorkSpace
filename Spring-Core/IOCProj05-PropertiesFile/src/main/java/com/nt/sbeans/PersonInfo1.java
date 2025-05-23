//PersonInfo1.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("pInfo1")
@PropertySource("com/nt/commons/Info.properties")
public class PersonInfo1 {
	@Autowired
	private Environment  env;
	
	
	@Override
	public String toString() {
		return   "name:"+env.getProperty("per.name")+" "+env.getProperty("per.age")+"\n"
				     +"os name::"+env.getProperty("os.name")+"\n Path data::"+env.getProperty("Path");
	}
	


	
	

}
