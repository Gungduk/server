package com.hybrid.gungduk.service;

public class SimpleRegistrationNotifier implements RegistrationNotifier {

	@Override
	public void sendMail(String userEmail, String uuid) {
		// TODO Auto-generated method stub
		
	}

//	private MailSender mailSender;
//
//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
//
//	@Override
//	public void sendMail(String userEmail, String uuid) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setSubject("[GUNGDUK] 임시 비밀번호 안내");
//		message.setFrom("gungduk.adm@gmail.com");
//		message.setText("임시 비밀번호는 \n"+uuid+"\n입니다.");
//		message.setTo(userEmail);
//		try {
//			mailSender.send(message);
//		} catch (MailException ex) {
//			ex.printStackTrace();
//		}
//
//	}
}
