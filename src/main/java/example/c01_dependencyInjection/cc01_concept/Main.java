package example.c01_dependencyInjection.cc01_concept;

public class Main {
    public static void main(String[] args) {
        MailService mailService = (MailService) Injector.getInstance("MAIL_SERVICE");
        Controller controller = new Controller(mailService);
        controller.send("send nude");
    }
}
