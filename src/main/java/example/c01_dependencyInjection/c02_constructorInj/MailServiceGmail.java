package example.c01_dependencyInjection.c02_constructorInj;

public class MailServiceGmail implements MailService {
    public MailServiceGmail(String sender){
        System.out.println("Hello: " + sender);
    }

    @Override
    public void sendMess(String mess) {
        System.out.println("GMAIL: " + mess);
    }
}
