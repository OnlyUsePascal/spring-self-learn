package example.c04_data.cc04_spring_data_jpa.jpa_style;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // custom 1
    List<Student> findAllByNameAndId(String name, int id);

    // custom 2
    @Query("select st from Student st where st.name like ?1 and st.id >= ?2")
    List<Student> findAllByName(String name, int id);

    // transactional
    Student findOneByName(String name);
}
