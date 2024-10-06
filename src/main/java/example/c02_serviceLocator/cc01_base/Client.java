package example.c02_serviceLocator.cc01_base;

public class Client {
    public static void main(String[] args) {
        MailService mailService = new MailServiceGmail();
        mailService.sendMess("send nude ?");
    }
}
