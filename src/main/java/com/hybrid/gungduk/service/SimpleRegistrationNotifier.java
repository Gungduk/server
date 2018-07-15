package com.hybrid.gungduk.service;

import java.util.UUID;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestParam;


public class SimpleRegistrationNotifier implements RegistrationNotifier {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(String userEmail, String uuid) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[GUNGDUK] 임시 비밀번호 안내");
		message.setFrom("gungdukapp@gmail.com");
		message.setText("임시 비밀번호는 \n"+uuid+"\n입니다.");
		message.setTo(userEmail);
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}

	}
}
