package com.blue.code.java.utils.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.pmw.tinylog.Logger;

import com.blue.code.java.utils.model.MailSender;

/**
 * Util class for send mail.
 * @author Julio Cesar Bolaños Palacios
 * @since 12/01/2017
 * @version 1.0
 */
public class GMailSenderUtil {
	// Set values

	public static void sendMail(MailSender mail) throws MessagingException {
		Logger.info("Try send mail with data: {}",  mail);
		// Recipient's email ID needs to be mentioned.
		String to = mail.getTo();

		// Sender's email ID needs to be mentioned
		String from = mail.getUsername();
		final String username = mail.getUsername();
		final String password = mail.getPassword();

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(mail.getSubject());

			// Now set the actual message
			message.setText(mail.getMessage());

			// Send message
			Transport.send(message);

			Logger.info("Sent message successfully....");
		} catch (MessagingException e) {
			Logger.error("An error ocurren when try send email messages.");
			Logger.error(e);
			throw e;
		}
	}

}

