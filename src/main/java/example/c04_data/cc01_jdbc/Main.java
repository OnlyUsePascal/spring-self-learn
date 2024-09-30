package example.c04_data.cc01_jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Main {
    // TODO: convert variables to env
    String host = "localhost";
    String db = "selfLearn-c04-01-01-jdbc";
    String port = "3306";
    String user = "root";
    String pwd = "root";
    String conUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;

    public void mainFunc() throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(conUrl, user, pwd);

        // _Basics.exec(connection);
        // _Prepared.exec(connection);
        _Transaction.exec(connection);

        // NOTE: always close connection
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().mainFunc();
    }

}
