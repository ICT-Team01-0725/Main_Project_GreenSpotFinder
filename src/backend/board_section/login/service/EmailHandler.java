package com.ict.project.login.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailHandler {
	private JavaMailSender javaMailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public EmailHandler(JavaMailSender javaMailSender) throws MessagingException {
		this.javaMailSender= javaMailSender;
		message = this.javaMailSender.createMimeMessage();
		
		messageHelper = new MimeMessageHelper(message,true, "utf-8");
	}
	
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}
	
	public void setText(String text) throws MessagingException {
		messageHelper.setText(text, true);
	}
	
	public void setForm(String email, String name) throws UnsupportedEncodingException, MessagingException {
		messageHelper.setFrom(email, name);
	}
	
	public void setTo(String email) throws MessagingException {
		messageHelper.setTo(email);
	}
	
	public void send() {
		javaMailSender.send(message);
	}
	
}
