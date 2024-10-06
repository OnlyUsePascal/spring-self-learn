package example.c01_dependencyInjection.cc02_constructorInj;

public class Controller {
    private MailService mailService;

    public Controller(MailService mailService) {
        this.mailService = mailService;
    }

    public void send(String m) {
        mailService.sendMess(m);
    }
}