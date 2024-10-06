package example.c01_dependencyInjection.cc03_setterInj.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:c01_03.properties")
public class AppConfig {
    // COMMENT THIS WHOLE CONTENT IF YOU WANNA USE IN-CLASS ANNOTATION
    final String service = "MAIL_SERVICE";

    @Bean
    @Qualifier("gmail")
    @Value("${service.gmail.user}")
    public MailServiceGmail getMailServiceGmail(String user) {
        return new MailServiceGmail(user);
    }

    @Bean
    @Qualifier("outlook")
    public MailServiceOutlook getMailServiceOutlook() {
        return new MailServiceOutlook();
    }

    @Bean
    public Controller getController() {
        return new Controller();
    }

    @Autowired
    public void setMailService(Controller controller,
                               @Qualifier("outlook") MailService mailService){
        controller.setMailService(mailService);
    }
}
