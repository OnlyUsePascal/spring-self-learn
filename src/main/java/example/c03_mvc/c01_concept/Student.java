package example.c03_mvc.c01_concept;

import java.time.LocalDate;

public class Student {
    int id;
    String name;
    LocalDate updated;

    public Student(int id, String name, LocalDate updated) {
        this.id = id;
        this.name = name;
        this.updated = updated;
    }

    public void setName(String name) throws Exception {
        if (name.matches(".*\\d.*")) throw new Exception("[!] name must not have number");
        this.name = name;
        this.updated = LocalDate.now();
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
