package com.nexus.mail.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MailProperties {

    private String emailAdmin;
    private String passwordAdmin;
}
