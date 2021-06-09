package 네이버메일;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NaverMail {
	public static void main(String[] args) {		
		String host = "smtp.naver.com";
		String user = "rnjstnals120";
		String password = "[kwon5582]";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user,password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("wjdwlgns120@naver.com") );
			
			message.setSubject("테스트 메일");
			message.setText("HI!");
			
			Transport.send(message);
			System.out.println("메일보내기 성공");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}