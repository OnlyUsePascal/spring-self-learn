package example.c04_data.cc02_hibernate;

import org.hibernate.Session;

public class _Transaction {
    public void exec() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // retrieve & update
            WalletUser walletUser = session.get(WalletUser.class, 1);
            System.out.println(walletUser);
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
}