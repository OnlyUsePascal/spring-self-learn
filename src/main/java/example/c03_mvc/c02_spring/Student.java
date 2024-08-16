package example.c03_mvc.c02_spring;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Student {
    Integer id;
    String name;
    LocalDateTime updated;

    public Student(Integer id, String name, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) throws Exception {
        if (name == null) throw new Exception("[!] name must not null");
        if (name.matches(".*\\d.*")) throw new Exception("[!] name must not have number");
        this.name = name;
        setUpdated(LocalDateTime.now());
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updated=" + updated +
                '}';
    }
}
