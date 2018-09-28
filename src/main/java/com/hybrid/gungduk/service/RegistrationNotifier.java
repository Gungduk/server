package com.hybrid.gungduk.service;

public interface RegistrationNotifier {

	public void sendMail(String userEmail, String uuid);
}