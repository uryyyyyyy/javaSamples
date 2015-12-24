package com.github.uryyyyyyy.javaSamples.apacheCommons;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSample {

	public static void sendMail(){
		try {
			Email mail = new SimpleEmail();
			mail.setCharset("UTF-8");
			mail.setHostName("smtpHost");
			mail.setFrom("sample@gmail.com");
			mail.addTo("sample@gmail.com");
			mail.setSubject("subject");
			mail.setMsg("mail content");
			mail.send();
		}catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
