package MailSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import static javax.mail.Session.getDefaultInstance;

public class EmailSender {
    public EmailSender() throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\IdeaProjects\\lab4-8\\src\\MailSender\\mail.properties"));

        Session mailSession=Session.getDefaultInstance(properties);
        MimeMessage msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress("kozyrskiyvitaliy10a@gmail.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kozursky0308@gmail.com"));
        msg.setSubject("Log File");
        msg.setText("Test");

        Transport transport = mailSession.getTransport();
        transport.connect(null,"udftvkptlyanjfon");
        transport.sendMessage(msg,msg.getAllRecipients());
        transport.close();
    }
}
