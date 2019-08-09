package com.dms.testservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class TestMailService.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private String receiverEmail = "harsh.patidar@impetus.co.in";
	
	private String subject = "Testing";
	
	private String body = "Mail for testing";
	
	private SimpleMailMessage mail = new SimpleMailMessage();
	
	@Test
	public void testSendMail() {
		mail.setTo(receiverEmail);
		mail.setFrom("mailer.dims@gmail.com");
		mail.setSubject(subject);
		mail.setText(body);
		javaMailSender.send(mail);
	}
}
