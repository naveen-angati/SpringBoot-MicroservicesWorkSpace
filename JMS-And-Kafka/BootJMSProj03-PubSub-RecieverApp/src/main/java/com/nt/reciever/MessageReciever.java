package com.nt.reciever;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever   {

	 @JmsListener(destination = "testtp1")
	  public   void  showMessage(String text) {
		  System.out.println("The read message is ::"+text);
	  }
	
}
