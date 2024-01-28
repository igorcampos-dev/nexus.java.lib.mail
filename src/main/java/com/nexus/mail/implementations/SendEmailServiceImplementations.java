package com.nexus.mail.implementations;

import com.nexus.mail.SendEmailService;
import com.nexus.mail.properties.MailProperties;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

@Service
@AllArgsConstructor
public class SendEmailServiceImplementations implements SendEmailService {

    private final MailProperties properties;

    public JavaMailSender MailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(properties.getEmailAdmin());
        mailSender.setPassword(properties.getPasswordAdmin());
        mailSender.setDefaultEncoding("UTF-8");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");
        return mailSender;
    }

    @SneakyThrows
    @Override
    public void send(String email, String subject, String messages, String filename, Resource image)  {
        try {
            JavaMailSender emailSender = MailSender();
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(properties.getEmailAdmin());
            helper.setTo(email.toLowerCase());
            helper.setSentDate(new Date());

            if (subject != null){helper.setSubject(subject);}
            if (message != null){helper.setText(messages, true);}
            if (filename != null && image != null){helper.addAttachment(Objects.requireNonNull(filename), image);}

            emailSender.send(message);
        } catch (MessagingException e) {
            throw new MessagingException("O servidor encontrou uma falha ao tentar enviar o email. Por favor, tente novamente mais tarde.");
        }
    }
}
