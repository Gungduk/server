package com.hybrid.gungduk.controller;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.service.SimpleRegistrationNotifier;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")

@Api(value="MailSender", description="메일 API", basePath="/api/v1/mail")
@RestController
public class MailController {

	@RequestMapping(value = "/api/v1/mail", method = RequestMethod.POST)
//	public void mailSender(@RequestParam String email) {
	public void mailSender() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-mail.xml");
		SimpleRegistrationNotifier simpleNotifier = ctx.getBean("simpleNotifier", SimpleRegistrationNotifier.class);
		simpleNotifier.sendMail();
		
		ctx.close();

	}
}
