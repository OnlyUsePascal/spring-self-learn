package example.c04_data.cc02_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    static EntityManager entityManager = null;
    static String unitName = "persistence";

    static public EntityManager getEntityManager() {
        if (entityManager != null) return entityManager;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(unitName);
            return entityManagerFactory.createEntityManager();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return null;
    }

    static public void shutdown() {
        if (entityManager != null) entityManager.close();
    }
}
