package example.c01_dependencyInjection.cc03_setterInj.annotation;

// @Component
public class MailServiceGmail implements MailService {
    public MailServiceGmail(String user) {
        System.out.println("Hello " + user);
    }

    @Override
    public void sendMess(String mess) {
        System.out.println("GMAIL: " + mess);
    }
}
