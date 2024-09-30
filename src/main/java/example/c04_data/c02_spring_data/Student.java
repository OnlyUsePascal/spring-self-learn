// package example.c04_data.c02_spring_data;
//
// import org.springframework.data.annotation.Id;
// import org.springframework.data.relational.core.mapping.Table;
//
//
// @Table
// public class Student {
//     @Id
//     int id;
//     String name;
//     int balance = 1000;
//
//     public Student() {
//     }
//
//     public Student(String name) {
//         this.name = name;
//     }
//
//     public int getBalance() {
//         return balance;
//     }
//
//     public void setBalance(int balance) {
//         this.balance = balance;
//     }
//
//     public void increaseBalance(int amount) {
//         this.balance += amount;
//     }
//
//     public int getId() {
//         return id;
//     }
//
//     public void setId(int id) {
//         this.id = id;
//     }
//
//     public String getName() {
//         return name;
//     }
//
//     public void setName(String name) {
//         this.name = name;
//     }
//
//     @Override
//     public String toString() {
//         return "Student{" +
//                 "id=" + id +
//                 ", name='" + name + '\'' +
//                 ", balance=" + balance +
//                 '}';
//     }
// }
