package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender   {
	@Autowired
  private JmsTemplate  template;
	
	int  count=0;

	@Scheduled(cron = "*/10 * * * * *")
		public void sendMessage() throws Exception {
		template.send("testmq1", ses->ses.createTextMessage(" Text message ::"+new Date()));
		count++;
		System.out.println("Message  sent...."+count);
	}
	
	
}
