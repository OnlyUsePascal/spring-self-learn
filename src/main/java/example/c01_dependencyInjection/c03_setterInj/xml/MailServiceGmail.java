package example.c01_dependencyInjection.c03_setterInj.xml;

public class MailServiceGmail implements MailService {
    public MailServiceGmail (String user) {
        System.out.println("Greeting! " + user);
    }

    @Override
    public void sendMess(String mess) {
        System.out.println("GMAIL: " + mess);
    }
}
