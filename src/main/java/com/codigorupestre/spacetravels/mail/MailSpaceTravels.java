package com.codigorupestre.spacetravels.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSpaceTravels {
	
	
	
	public void sendMail(String emailTo) {
		
		//quien va  a enviar el correo
		String from = "adriancarpiomoran@gmail.com";
		
		String userName = "adriancarpiomoran@gmail.com";
		String password = "0951577675";
		
		String host = "smtp.gmail.com";
		
		Properties props = new  Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(userName,password);
			}
			
		});
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject("Welcome to Space Travels");
			
			message.setText("Welcome to Space Travels Confirm your Email");
			Transport.send(message);
			
			System.out.println("Maiel enviado de forma exitosa a " + emailTo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
