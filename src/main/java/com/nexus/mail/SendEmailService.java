package com.nexus.mail;

import com.nexus.mail.models.EmailProperties;
import com.nexus.mail.properties.MailProperties;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Properties;

@Service
@AllArgsConstructor
public class SendEmailService {

    private final MailProperties properties;

    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        configureMailSender(mailSender);
        configureMailProperties(mailSender);
        return mailSender;
    }

    private void configureMailSender(JavaMailSenderImpl mailSender) {
        mailSender.setHost(properties.getHost());
        mailSender.setDefaultEncoding(properties.getUTF());
        mailSender.setPort(properties.getPort());
        mailSender.setUsername(properties.getEmail());
        mailSender.setPassword(properties.getPassword());
    }

    private void configureMailProperties(JavaMailSenderImpl mailSender) {
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");
    }

    public void send(EmailProperties emailProperties)  {
            JavaMailSender emailSender = mailSender();
            MimeMessage message = createMimeMessage(emailSender);
            MimeMessageHelper helper = createMimeMessageHelper(message, emailProperties.multiPart());
            configureHelper(helper, emailProperties );
            emailSender.send(message);
    }

    private MimeMessage createMimeMessage(JavaMailSender emailSender) {
        return emailSender.createMimeMessage();
    }

    private MimeMessageHelper createMimeMessageHelper(MimeMessage mimeMessage, boolean multiPart){
        try {
            return new MimeMessageHelper(mimeMessage, multiPart);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private void configureHelper(MimeMessageHelper helper, EmailProperties emailProperties){
        try {
        helper.setFrom(properties.getEmail());
        helper.setTo(emailProperties.email());
        helper.setSentDate(emailProperties.date());
        helper.setSubject(emailProperties.subject());
        helper.setText(emailProperties.messages(), true);

        if (emailProperties.filename() != null && emailProperties.image() != null){helper.addAttachment(Objects.requireNonNull(emailProperties.filename()), emailProperties.image());}
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
