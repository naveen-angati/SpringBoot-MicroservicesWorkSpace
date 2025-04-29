//PurchaseOrderServiceImpl.java
package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseService")
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	@Value("${spring.mail.username}")
	private String  senderEmail;
	@Value("${spring.mail.password}")
	private String   senderPwd;
	@Autowired
	private JavaMailSender  sender;

	@Override
	public String purchase(String[] items, double[] prices, String[] ToEmails)throws Exception {
		double billAmt=0.0;
		for(double p:prices)
			 billAmt=billAmt+p;
		String msg=Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+" with the bill amount::"+billAmt;
		
		String result=sendEmails(ToEmails,msg);
				
		return result+"....... "+msg;
	}
	
	private  String  sendEmails(String ToEmails[],String msg) throws Exception{
		//create MimeMessage  from the Sender object
		MimeMessage mimeMessage=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		helper.setFrom(senderEmail);
		helper.setTo(ToEmails);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("nit.png",new ClassPathResource("nit.png"));
		sender.send(mimeMessage);
		return "mail sent";
		
	}

}
