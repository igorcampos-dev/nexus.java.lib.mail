package com.nexus.mail.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.mail.admin")
public class MailProperties {

    private String email;
    private String password;
    private String UTF = "UTF-8";
    private String host = "smtp.gmail.com";
    private int port = 587;
}
