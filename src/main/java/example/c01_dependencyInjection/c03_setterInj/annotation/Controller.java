package example.c01_dependencyInjection.c03_setterInj.annotation;

// @Component
public class Controller {
    private MailService mailService;

    // @Autowired
    // @Qualifier("mailServiceGmail")
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void send(String m) {
        mailService.sendMess(m);
    }
}