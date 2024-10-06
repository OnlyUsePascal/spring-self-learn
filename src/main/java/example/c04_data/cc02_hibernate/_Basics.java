package example.c04_data.cc02_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class _Basics {
    public void execJpa() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            Student student = entityManager.find(Student.class, 1);
            // System.out.println(student);

            // SQL query
            List<Student> students = entityManager
                    .createNativeQuery("select * from Students;",Student.class)
                    .getResultList();
            // System.out.println(students);

            // JPQL query
            Query query = entityManager
                    .createQuery("select st from Student st where st.name like :name", Student.class)
                    .setParameter("name", "jo%");
            students = query.getResultList();
            // System.out.println(students);
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void execHibernate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Student student = session.get(Student.class, 1);
            // System.out.println(student);

            // SQL query
            List<Student> students = session
                    .createNativeQuery("select * from Students;",Student.class)
                    .list();
            // System.out.println(students);

            // HQL query
            students = session.createQuery("FROM Student AS st where st.name like :name")
                    .setParameter("name", "jo%")
                    .list();
            // System.out.println(students);
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            session.close();
        }
    }
}
