package mail.properties;

import com.nexus.mail.properties.MailProperties;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MailPropertiesTest {

    @Test
    void testMailProperties() {
        String email = "example@example.com";
        String password = "password";
        String utf = "UTF-8";
        String host = "smtp.gmail.com";
        int port = 587;

        MailProperties mailProperties = new MailProperties();
        mailProperties.setEmail(email);
        mailProperties.setPassword(password);
        mailProperties.setUTF(utf);
        mailProperties.setHost(host);
        mailProperties.setPort(port);

        assertNotNull(mailProperties);
        assertEquals(email, mailProperties.getEmail());
        assertEquals(password, mailProperties.getPassword());
        assertEquals(utf, mailProperties.getUTF());
        assertEquals(host, mailProperties.getHost());
        assertEquals(port, mailProperties.getPort());
    }
}
