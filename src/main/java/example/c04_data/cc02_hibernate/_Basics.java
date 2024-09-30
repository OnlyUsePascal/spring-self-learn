package example.c04_data.cc02_hibernate;

import org.hibernate.Session;

import java.util.List;

public class _Basics {
    public void exec() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

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
            System.out.println(students);

            session.getTransaction().commit();
        } catch (Exception err) {
            err.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
