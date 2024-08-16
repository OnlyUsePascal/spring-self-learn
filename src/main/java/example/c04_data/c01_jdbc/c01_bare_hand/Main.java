package example.c04_data.c01_jdbc.c01_bare_hand;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Main {
    // TODO: convert variables to env
    String host = "localhost";
    String db = "selfLearn-c04-01-jdbc";
    String port = "3306";
    String user = "root";
    String pwd = "123";
    String conUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;



    public void basicQuery(Connection connection) throws SQLException {
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

        // prepared statement
        query = "select * from Students where name like ?";
        System.out.println(query);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "jo%"); // index from 1

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name")));
        }
    }


    public void transactionQuery(Connection connection) throws Exception {
        connection.setAutoCommit(false);

        String queryUpdate = "UPDATE USER_WALLETS SET balance = balance + ? where name = ? ;";
        String sender = "Joun", recipient = "Joph";
        int amount = 100;

        // #1: reduce sender balance
        // assume that sender is legit
        PreparedStatement updateStatement = connection.prepareStatement(queryUpdate);
        updateStatement.setInt(1, -amount);
        updateStatement.setString(2, sender);
        updateStatement.executeUpdate();

        // #2: increase recipient balance
        // assume recipient doesn't exist
        String queryGet = "SELECT * FROM USER_WALLETS WHERE name = ?";
        PreparedStatement getStatement = connection.prepareStatement(queryGet);
        getStatement.setString(1, recipient);

        ResultSet resultSet = getStatement.executeQuery();
        if (!resultSet.next()) throw new Exception("Recipient not found !!!");

        // update balance
        updateStatement.setInt(1, amount);
        updateStatement.setString(2, recipient);
        updateStatement.executeUpdate();

        connection.commit();
        connection.setAutoCommit(true);
    }





    public void mainFunc() throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(conUrl, user, pwd);

        // basicQuery(connection);
        // transactionQuery(connection);

        // NOTE: always close connection
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().mainFunc();
    }

}
