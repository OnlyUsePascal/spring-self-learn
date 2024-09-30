// package example.c04_data.c02_spring_data;
//
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.transaction.annotation.Transactional;
//
// import java.util.NoSuchElementException;
//
// public class Main {
//     @Transactional(rollbackFor = {NoSuchElementException.class})
//     public static void transactionalQuery(StudentRepository repository, int idSender,
//                                           int idReceiver, int amount) {
//         System.out.println("Transaction begin");
//
//         Student sender = repository.findById(Long.valueOf(idSender)).get();
//         sender.setBalance(sender.getBalance() - amount);
//
//         Student receiver = repository.findById(Long.valueOf(idReceiver)).get();
//         receiver.setBalance(sender.getBalance() + amount);
//         System.out.println("Transaction end");
//
//     }
//
//
//     public static void main(String[] args) {
//         ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//         System.out.println("App init done!");
//         StudentService studentService = context.getBean(StudentService.class);
//
//         studentService.basicQuery();
//         studentService.transactionQuery();
//     }
// }
