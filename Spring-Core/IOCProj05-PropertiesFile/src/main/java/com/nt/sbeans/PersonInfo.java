//PersonInfo.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("pInfo")
@PropertySource("com/nt/commons/Info.properties")
public class PersonInfo {
	@Value("${per.name}")
	private String pname;
	@Value("${per.addrs}")
	private  String paddrs;
	@Value("${per.age}")
	private  int page;
	
	@Value("${os.name}")  //os.name is the fixed sytem property key
	private  String osName;
	@Value("${user.name}")  // user.name is  the fixed system property key
	private  String  uname;
	
	@Value("${Path}")
	private   String pathData;


	
	//toString
	@Override
	public String toString() {
		return "PersonInfo [pname=" + pname + ", paddrs=" + paddrs + ", page=" + page + ", osName=" + osName
				+ ", uname=" + uname + ", pathData=" + pathData + "]";
	}
	
	

}
