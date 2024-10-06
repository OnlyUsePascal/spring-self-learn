package example.c04_data.cc00_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao implements Dao<Student> {
    List<Student> students;

    public StudentDao() {
        students = new ArrayList<>();
        students.add(new Student(1, "joun nguyen"));
        students.add(new Student(3, "dat pham"));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Optional<Student> get(int id) {
        return students.stream()
                .filter(student -> student.hasId(id))
                .findFirst();
    }

    @Override
    public void update(Student st) throws Exception {
        Student student = get(st.id).get();
        student.setName(st.getName());
    }
}
