package example.c04_data.cc03_spring_jdbc;

import java.sql.SQLException;

public class Main {
    public void exec() throws SQLException {
        new _Basics().exec();
        // new _PreparedStatement().execJdbcTemplate();
        // new _PreparedStatement().execNamedTemplate();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");
        new Main().exec();
    }
}