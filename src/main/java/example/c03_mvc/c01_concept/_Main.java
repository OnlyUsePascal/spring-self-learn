package example.c03_mvc.c01_concept;

public class _Main {
    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller(new View(), new Model());
        controller.showInfo();
        controller.changeName("Dat Nguyen");
        controller.showInfo();
        controller.changeName("Dat Nguyen2");
    }
}
