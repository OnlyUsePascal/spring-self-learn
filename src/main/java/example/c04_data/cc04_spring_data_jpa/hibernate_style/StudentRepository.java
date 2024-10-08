package example.c04_data.cc04_spring_data_jpa.hibernate_style;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// NEED INTERFACE, BUT I'M LAZY
@Repository
public class StudentRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        List<Student> students = session
                .createNativeQuery("select * from Students", Student.class)
                .list();
        session.close();
        return students;
    }

    public List<Student> findAllByNameAndId(String name, int id) {
        Session session = sessionFactory.openSession();
        List<Student> students = null;
        String hql = "from Student st where st.name like :name and st.id >= :id";

        students = session
                .createQuery(hql, Student.class)
                .setParameter("name", name)
                .setParameter("id", id)
                .list();
        session.close();
        return students;
    }

}


