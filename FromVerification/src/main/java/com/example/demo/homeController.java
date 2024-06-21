package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class homeController {

	@Autowired
	Verification verifi;
	
	@Autowired
	public JavaMailSender javasend;
	public String home()
	{
		System.out.println("Compiled Successfully!...");
		return "home";
	}
	
	public String home1(VerifyDetails details)
	{
		verifi.save(details);
		sendSimpleEmail(details.getEmail(),"From Submission","Form has been submitted successfully");
		return "home";
	}
	
	 private void sendSimpleEmail(String to, String subject, String body) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        javasend.send(message);
	    }
}
