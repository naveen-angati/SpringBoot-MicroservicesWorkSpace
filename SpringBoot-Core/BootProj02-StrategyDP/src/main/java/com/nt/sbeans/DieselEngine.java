//DieselEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngg")
public class DieselEngine implements Engine {
	
	public DieselEngine() {
		System.out.println("DesielEngine:: 0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("DieselEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()");

	}

}
