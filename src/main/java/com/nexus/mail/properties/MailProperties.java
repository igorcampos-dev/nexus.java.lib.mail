package com.nexus.mail.properties;

import lombok.Data;

@Data
public class MailProperties {

    private String email;
    private String password;
    private String UTF = "UTF-8";
    private String host = "smtp.gmail.com";
    private int port = 587;
}
