package example.c02_serviceLocator.c01_base;

public class MailServiceOutlook implements MailService{
    @Override
    public String getMessTitle() {
        return "Outlook: ";
    }

    @Override
    public void sendMess(String mess) {
        System.out.println(getMessTitle() + " $..." + mess);
    }
}
