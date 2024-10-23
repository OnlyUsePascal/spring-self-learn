package example.c03_mvc.cc01_1_concept;

import java.time.format.DateTimeFormatter;

public class View {
    public void showInfo(Student student) {
        System.out.println("[@] Student Info");
        System.out.println("+ Name: " + student.name);
        System.out.println("+ Name: " + student.updated.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public void showUpdateStatus(String mess) {
        System.out.println(mess);
    }

    public void showError(Exception exception) {
        System.out.println("[x] Some error happends");
        exception.printStackTrace();
    }
}
