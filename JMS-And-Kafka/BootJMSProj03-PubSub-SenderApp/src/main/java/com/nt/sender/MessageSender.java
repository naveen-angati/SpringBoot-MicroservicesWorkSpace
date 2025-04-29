package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender  implements  CommandLineRunner {
	@Autowired
  private JmsTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		template.send("testtp1", ses->ses.createTextMessage(" Text message ::"+new Date()));
	}
	
	
}
