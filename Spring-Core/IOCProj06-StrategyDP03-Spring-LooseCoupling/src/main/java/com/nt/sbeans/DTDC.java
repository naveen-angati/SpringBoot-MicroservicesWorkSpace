//DTDC.java (dependent class1)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public final class DTDC implements Courier {

	@Override
	public String deliver(int oid) {
		
		return oid+" order  items are kept for delivery by DTDC";
		
	}

}
