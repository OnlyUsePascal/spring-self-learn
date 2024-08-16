package example.c03_mvc.c02_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Model {
    List<Student> students = new ArrayList<>();

    public Model(){
        students.add(new Student(1, "joun nguyen", LocalDateTime.now()));
        students.add(new Student(3, "dat pham", LocalDateTime.now()));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void changeStudent(Integer id, String name) throws Exception {
        students.stream()
                .filter(st -> st.id.equals(id)).findFirst()
                .orElseThrow(() -> new Exception("[!] No student with id " + id.toString() + " found!"))
                .setName(name);
    }
}
