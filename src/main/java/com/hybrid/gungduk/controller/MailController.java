package com.hybrid.gungduk.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.gungduk.dao.EmailDao;
import com.hybrid.gungduk.service.SimpleRegistrationNotifier;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@Api(value="MailSender", description="메일 API", basePath="/api/v1/mail")
@RestController
@Controller
public class MailController {
	
	@Autowired
	EmailDao emailDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/api/v1/mail", method = RequestMethod.POST)
	public void mailSender(@RequestParam String id) {
		String userEmail = emailDao.searchEmail(id);
		String uuid = UUID.randomUUID().toString().replace("-", "");
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-mail.xml");
		SimpleRegistrationNotifier simpleNotifier = ctx.getBean("simpleNotifier", SimpleRegistrationNotifier.class);
		simpleNotifier.sendMail(userEmail, uuid);
		
		String encPw = passwordEncoder.encode(uuid);
		emailDao.updatePw(encPw, id);
		
		ctx.close();

	}
}