package com.nexus.mail.bean;

import com.nexus.mail.properties.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MailBean {

    @Bean
    public MailProperties mailProperties(){
        return new MailProperties();
    }
}
