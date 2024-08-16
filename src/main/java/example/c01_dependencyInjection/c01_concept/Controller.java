package example.c01_dependencyInjection.c01_concept;

public class Controller {
    private MailService mailService;

    public Controller(MailService mailService) {
        this.mailService = mailService;
    }

    public void send(String m) {
        mailService.sendMess(m);
    }
}