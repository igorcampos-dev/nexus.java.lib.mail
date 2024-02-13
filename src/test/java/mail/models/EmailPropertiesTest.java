package mail.models;

import com.nexus.mail.models.EmailProperties;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmailPropertiesTest {

    @Test
    void testEmailPropertiesBuilder() {
        String email = "example@example.com";
        String subject = "Test Email";
        String message = "This is a test email.";
        String filename = "test.txt";
        Resource image = null;
        Date date = new Date();
        Boolean multiPart = true;

        EmailProperties emailProperties = EmailProperties.builder()
                .email(email)
                .subject(subject)
                .messages(message)
                .filename(filename)
                .image(image)
                .date(date)
                .multiPart(multiPart)
                .build();

        assertNotNull(emailProperties);
        assertEquals(email, emailProperties.email());
        assertEquals(subject, emailProperties.subject());
        assertEquals(message, emailProperties.messages());
        assertEquals(filename, emailProperties.filename());
        assertEquals(image, emailProperties.image());
        assertEquals(date, emailProperties.date());
        assertEquals(multiPart, emailProperties.multiPart());
    }
}
