package mail.bean;

import com.nexus.mail.bean.MailBean;
import com.nexus.mail.properties.MailProperties;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MailBeanTest {

    @Test
    void testMailPropertiesBean() {
        MailBean mailBean = new MailBean();
        MailProperties properties = mailBean.mailProperties();
        assertNotNull(properties);
    }
}
