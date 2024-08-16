package example.c02_serviceLocator.c02_upgrade;

public class Client {
    public static void main(String[] args) {

        MailService mailService = ServiceLocator.getMailService("MailServiceGmail");
        mailService.sendMess("send nude ?");

        MailService mailService2 = ServiceLocator.getMailService("MailServiceGmail");
        mailService2.sendMess("hello world ?");

        MailService mailService3 = ServiceLocator.getMailService("MailServiceGmail");
        mailService3.sendMess("Listening to mp3");
    }
}
