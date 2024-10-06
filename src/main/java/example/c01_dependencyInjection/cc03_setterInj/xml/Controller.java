package example.c01_dependencyInjection.cc03_setterInj.xml;

public class Controller {
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void send(String m) {
        mailService.sendMess(m);
    }
}