package example.c04_data.cc01_jdbc;

import java.sql.*;

public class _Basics {
    static public void exec(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        // get query
        String query = "select * from Students;";
        System.out.println(query);

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
            System.out.println(student);
        }

        // insert
        query = "insert into Students(name) values ('john pham');";
        // query = "insert into Students(id, name) values (1, 'john pham');"; // error
        System.out.println(query);

        int rowAffected = statement.executeUpdate(query);
        if (rowAffected != 0) {
            System.out.println("Update table succeeded!");
        } else {
            System.out.println("Update table failed :(");
        }
    }
}
