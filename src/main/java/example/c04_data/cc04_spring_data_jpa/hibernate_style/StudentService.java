package example.c04_data.cc04_spring_data_jpa.hibernate_style;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public void execBasic() {
        repository.findAll().forEach(student -> {
            // System.out.println(student);
        });

        repository.findAllByNameAndId("jo%", 1).forEach(student -> {
            // System.out.println(student);
        });
    }

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class)
    public void execTransaction() throws Exception {
        // unwrap to get current session
        Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class, 1);

        student.setName("joun2.4");
        session.persist(student);
        if (true) throw new Exception("a random error");
    }
}
