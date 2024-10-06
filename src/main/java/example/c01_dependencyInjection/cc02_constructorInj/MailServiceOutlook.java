package example.c01_dependencyInjection.cc02_constructorInj;

public class MailServiceOutlook implements MailService {
    @Override
    public void sendMess(String mess) {
        System.out.println("OUTLOOK: " + mess);
    }
}
