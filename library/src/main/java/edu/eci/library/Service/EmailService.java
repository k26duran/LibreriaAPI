package edu.eci.library.Service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {
	 public static void enviarEmail(String email) {

	        final String username = "k26duran@gmail.com";
	        final String password = "Tortu4751";

	        Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "25");

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("k26duran@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(email));
	            message.setSubject("Email sobre la creacion de los libros");
	            message.setText("El libro se registro exitosamente");

	            Transport.send(message);

	            System.out.println("Working fine..!");

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}