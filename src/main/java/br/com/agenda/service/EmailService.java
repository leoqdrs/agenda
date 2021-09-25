package br.com.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.com.agenda.dto.EmailInput;

public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void enviaEmail(EmailInput email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom("leoqdrs@gmail.com");
		mailMessage.setSubject(email.getAssunto());
		mailMessage.setText(email.getCorpo());
		mailMessage.setTo(email.getDestinatario());
		mailSender.send(mailMessage);
	}

}
