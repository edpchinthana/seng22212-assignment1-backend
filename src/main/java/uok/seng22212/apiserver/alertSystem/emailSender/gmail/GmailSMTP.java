package uok.seng22212.apiserver.alertSystem.emailSender.gmail;

import org.springframework.beans.factory.annotation.Autowired;
import uok.seng22212.apiserver.alertSystem.EmailSender;
import uok.seng22212.apiserver.alertSystem.emailSender.EmailFormatter;
import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.AlertSubscriber;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class GmailSMTP implements EmailSender {

    @Autowired
    EmailFormatter emailFormatter;

    @Override
    public void sendEmails(Alert alert, List<AlertSubscriber> alertSubscriberList) {

        final String sender = "javaloganalyzer@gmail.com";
        final String password = "loganalyzer2020";
        String host = "smtp.gmail.com";
        String port = "465";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("javaloganalyzer@gmail.com"));
            message.setSubject("Alert! - Monitor Sensor Data Management System");
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textPart = new MimeBodyPart();
            String body =  emailFormatter.getEmailBody(alert);
            textPart.setText(body);
            multipart.addBodyPart(textPart);
            message.setContent(multipart);
            System.out.println("sending...email alerts");

            for(AlertSubscriber subscriber: alertSubscriberList){
                message.addRecipient(RecipientType.BCC, new InternetAddress(subscriber.getEmail()));
                Transport.send(message);
            }

        } catch (MessagingException var16) {
            var16.printStackTrace();
        }

    }
}
