package example.c03_mvc.cc01_concept;

import java.time.LocalDate;

public class Model {
    Student student = new Student(1, "Joun Pham", LocalDate.now());

    public Student getStudent() {
        return student;
    }

    public void changeName(String name) throws Exception {
        student.setName(name);
    }
}
