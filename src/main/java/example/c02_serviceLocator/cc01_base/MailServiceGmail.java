package example.c02_serviceLocator.cc01_base;

public class MailServiceGmail implements MailService{
    @Override
    public String getMessTitle() {
        return "Gmail: ";
    }

    @Override
    public void sendMess(String mess) {
        System.out.println(getMessTitle() + " >..." + mess);
    }
}
