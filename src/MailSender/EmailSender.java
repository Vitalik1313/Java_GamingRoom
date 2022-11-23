package MailSender;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import static javax.mail.Session.getDefaultInstance;

public class EmailSender {
    private final Properties properties;
    private Session mailSession;
    private Transport transport;
    private MimeMessage msg = null;

    public EmailSender() throws IOException, MessagingException {
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\IdeaProjects\\lab4-8\\src\\MailSender\\mail.properties"));
        mailSession=Session.getDefaultInstance(properties);
    }

     public void sendMsg(String msgText) throws MessagingException {
         msg = new MimeMessage(mailSession);
         msg.setFrom(new InternetAddress("*****"));
         msg.addRecipient(Message.RecipientType.TO, new InternetAddress("******"));
         msg.setSubject("LOG INFO");
         msg.setText(msgText);
         try {
             transport = mailSession.getTransport();
         } catch (NoSuchProviderException e) {
             throw new RuntimeException(e);
         }
         try {
             transport.connect(null,"****");
         } catch (MessagingException e) {
             throw new RuntimeException(e);
         }
         transport.sendMessage(msg,msg.getAllRecipients());
         try {
             transport.close();
         } catch (MessagingException e) {
             throw new RuntimeException(e);
         }
     }
}
