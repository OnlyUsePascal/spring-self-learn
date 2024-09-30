package example.c04_data.cc01_jdbc;

import java.sql.*;

public class _Prepared {
    static public void exec(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String query = "select * from Students where name like ?";
        System.out.println(query);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "jo%"); // index from 1

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name")));
        }
    }
}
