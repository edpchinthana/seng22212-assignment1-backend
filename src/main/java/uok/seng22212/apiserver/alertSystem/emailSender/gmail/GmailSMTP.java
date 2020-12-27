package uok.seng22212.apiserver.alertSystem.emailSender.gmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.alertSystem.emailSender.EmailSender;
import uok.seng22212.apiserver.alertSystem.emailSender.EmailFormatter;
import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.AlertSubscriber;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;

@Service
public class GmailSMTP implements EmailSender {

    @Autowired
    EmailFormatter emailFormatter;

    @Value("${mailSender.email}")
    private String sender;

    @Value("${mailSender.password}")
    private String password;

    @Value("${mailSender.host}")
    private String host;

    @Value("${mailSender.port}")
    private String port;

    @Override
    public void sendEmails(Alert alert, List<AlertSubscriber> alertSubscriberList) throws MessagingException {

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
            message.setFrom(new InternetAddress(sender));

            message.setSubject(emailFormatter.getEmailSubject());

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

        } catch (Exception e) {
            throw e;
        }

    }
}
