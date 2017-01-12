package com.blue.code.java.utils.model;


/**
 * Mail sender model.
 * @author Julio Cesar Bolaños Palacios
 * @since 12/01/2017
 * @version 1.0
 */
public class MailSender {
	private String to;
	private String subject;
	private String message;
	private String username;
	private String password;
	
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MailSender [to=" + to + ", subject=" + subject + ", message=" + message + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
