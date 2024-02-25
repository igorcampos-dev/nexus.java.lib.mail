package com.nexus.mail.properties;

import lombok.Builder;
import org.springframework.core.io.Resource;
import java.util.Date;

@Builder
public record EmailProperties(String email,
                              String subject,
                              String messages,
                              String filename,
                              Resource image,
                              Date date,
                              Boolean multiPart) {
}
