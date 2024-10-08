package example.c04_data.cc04_spring_data_jpa.jpa_style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public void execBasic() {
        // basic
        repository.findAll().forEach(student -> {
            // System.out.println(student);
        });

        repository.findAllByNameAndId("joun", 1).forEach(student -> {
            // System.out.println(student);
        });

        repository.findAllByName("jo%", 2).forEach(student -> {
            // System.out.println(student);
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public void execTransaction() throws Exception {
        Student st = repository.findById(1L).get();
        st.setName("joun3");

        repository.save(st);
        throw new Exception("some random error");
    }
}
