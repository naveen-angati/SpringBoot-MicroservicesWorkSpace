package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String epass1=encoder.encode("rani");
		String epass2=encoder.encode("hyd");
		String epass3=encoder.encode("delhi");
		String epass4=encoder.encode("vizag");
		System.out.println(epass1+"  "+epass2+"  "+epass3+"  "+epass4);
		
	}

}
