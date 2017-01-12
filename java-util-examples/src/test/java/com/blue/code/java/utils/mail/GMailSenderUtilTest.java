package com.blue.code.java.utils.mail;

import javax.mail.MessagingException;

import org.junit.Test;
import org.pmw.tinylog.Logger;

import com.blue.code.java.utils.model.MailSender;

public class GMailSenderUtilTest{
	
	@Test
	public void sendMailTest() throws MessagingException{
		Logger.info("----  Test Send Mail ----");
		MailSender sender = new MailSender();
		sender.setMessage("Test Message");
		sender.setTo("jcesar.linux@gmail.com");
		sender.setSubject("Test send mail");
		sender.setUsername("infraestructura.amk@gmail.com");
		sender.setPassword("1nfr435tructur4");
		
		GMailSenderUtil.sendMail(sender);
		Logger.info("----  End test ----");
	}
}
