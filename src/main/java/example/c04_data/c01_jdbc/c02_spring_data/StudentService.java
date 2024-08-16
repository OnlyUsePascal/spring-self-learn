package example.c04_data.c01_jdbc.c02_spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    StudentService(){}

    public void basicQuery() {
        // insert
        // Student s1 = new Student();
        // s1.setName("joseph " + Math.random());
        // Student s1Saved = repository.save(s1);

        // update
        Student s2 = repository.findById(Long.valueOf(1)).get();
        s2.setName("Joun test 2");
        repository.save(s2);

        // get
        System.out.println("built-int");
        repository.findAll().forEach(System.out::println);

        // prepared statement - jdbc
        // System.out.println("prepared statement - jdbc");
        // repository.findByName("jo%").forEach(System.out::println);

        // prepared statement - boot
        // System.out.println("prepared statement - jpa");
        // repository.findby(14).forEach(System.out::println);
    }

    @Transactional
    public void transactionQuery() {
        int idSender = 3;
        int idReceiver = 1;
        int amount = 100;

        Student sender = repository.findById(Long.valueOf(idSender)).get();
        sender.setBalance(sender.getBalance() - amount);

        Student receiver = repository.findById(Long.valueOf(idReceiver)).get();
        receiver.setBalance(sender.getBalance() + amount);
    }
}
