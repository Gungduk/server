package com.hybrid.gungduk.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class SimpleRegistrationNotifier implements RegistrationNotifier {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[GUNGDUK] 임시 비밀번호 안내");
		message.setFrom("gungdukapp@gmail.com");
		message.setText("임시 비밀번호 입니다.");
//		message.setTo(member.getEmail());
		message.setTo("seoha9630@gmail.com");
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}

	}
}
