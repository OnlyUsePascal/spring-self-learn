// package example.c04_data.c02_spring_data;
//
// import org.springframework.data.jdbc.repository.query.Query;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;
//
// @Repository
// public interface StudentRepository extends CrudRepository<Student, Long> {
//     // basic query
//     @Override
//     Iterable<Student> findAll();
//
//     // prepared (spring jdbc)
//     @Query("SELECT * FROM student st WHERE st.name LIKE :name")
//     Iterable<Student> findByName(@Param("name") String name);
//
//     // prepared native (spring jpa / hibernate)
//     // @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM student st WHERE st.balance >= ?1",
//     //         nativeQuery = true)
//     // Iterable<Student> findByBalance(int balance);
//
//
// }
