package MailSenderTest;

import Logger.MyLogger;
import MailSender.EmailSender;
import org.junit.Assert;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class TestCreatingSender {
    @Test
    public void TestCreating() throws IOException {
        MyLogger log = new MyLogger();
        try {
            EmailSender sender = new EmailSender();
            Assert.assertNotNull(sender);
        } catch (MessagingException e) {
            MyLogger.getLogger().severe("Cannot create sender to email");
        }
    }
}
