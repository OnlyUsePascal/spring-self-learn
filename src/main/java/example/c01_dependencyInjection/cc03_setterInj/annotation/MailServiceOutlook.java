package example.c01_dependencyInjection.cc03_setterInj.annotation;

// @Component
public class MailServiceOutlook implements MailService {
    @Override
    public void sendMess(String mess) {
        System.out.println("OUTLOOK: " + mess);
    }
}
