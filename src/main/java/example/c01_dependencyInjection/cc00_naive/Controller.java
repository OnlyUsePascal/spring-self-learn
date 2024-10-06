package example.c01_dependencyInjection.cc00_naive;

public class Controller {
    public void send(String mess) {
        ServiceGmail serviceGmail = new ServiceGmail();
        serviceGmail.sendMessage(mess);
    }
}
