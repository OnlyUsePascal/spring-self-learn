package example.c01_dependencyInjection.c00_naive;

public class ServiceGmail {
    public void sendMessage(String mess) {
        System.out.println("GMAIL: " + mess);
    }
}
