package com.nexus.mail.bean;

import com.nexus.mail.SendEmailService;
import com.nexus.mail.properties.MailProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailBean {

    private final MailProperties mailProperties;

    @Bean
    SendEmailService emailService(){
        return new SendEmailService(mailProperties);
    }

}