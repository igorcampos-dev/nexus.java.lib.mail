package com.nexus.mail;

import org.springframework.core.io.Resource;

public interface SendEmailService {
    void send(String email, String assunto, String mensagem, String filename, Resource image);
}
