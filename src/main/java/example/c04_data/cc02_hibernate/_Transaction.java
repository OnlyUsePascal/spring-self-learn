package example.c04_data.cc02_hibernate;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class _Transaction {
    public void execHibernate() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // retrieve & update
            WalletUser walletUser = session.get(WalletUser.class, 1);
            walletUser.setBalance(walletUser.getBalance() + 100);
            session.persist(walletUser);

            // runtime error
            if (true) throw new Exception("a random error");
            session.getTransaction().commit();
        } catch (Exception err) {
            err.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void execJpa() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            // retrieve + update
            WalletUser walletUser = entityManager.find(WalletUser.class, 1);
            walletUser.setBalance(walletUser.getBalance() + 100);

            // persist
            entityManager.persist(walletUser);
            if (true) throw new Exception("random error");

            entityManager.getTransaction().commit();
        } catch (Exception err) {
            err.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}