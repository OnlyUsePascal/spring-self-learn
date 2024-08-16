package example.c01_dependencyInjection.c00_naive;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.send("send nude");
    }
}
