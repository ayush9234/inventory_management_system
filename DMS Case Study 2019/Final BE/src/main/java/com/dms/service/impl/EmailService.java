package com.dms.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * The Class EmailService.
 */
@Service
public class EmailService {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(EmailService.class);

	/** The java mail sender. */
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * Send mail.
	 *
	 * @param receiverEmail the receiver email
	 * @param subject       the subject
	 * @param body          the body
	 */
	@Async
	public void sendMail(String receiverEmail, String subject, String body) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(receiverEmail);
		mail.setFrom("mailer.dims@gmail.com");
		mail.setSubject(subject);
		mail.setText(body);
		
		try {
			javaMailSender.send(mail);
		} catch (Exception e) {
			LOG.info(e);
			LOG.error("Mail cannot be sent");
		}
	}
}
