package example.c04_data.cc02_hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    static SessionFactory sessionFactory = null;
    static String configFileName = "c04-02/hibernate.cfg.xml";


    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) return sessionFactory;

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure(configFileName)
                    .build();

            // add annotated class
            MetadataSources metadataSources = new MetadataSources(registry);
            metadataSources.addAnnotatedClass(Student.class);
            metadataSources.addAnnotatedClass(WalletUser.class);
            Metadata metadata = metadataSources.buildMetadata();

            // session factory
            return metadata.buildSessionFactory();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return null;
    }

    static public void shutdown() {
        sessionFactory.close();
    }
}
