package example.c04_data.cc03_spring_jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class JDBCUtil {
    static private DataSource dataSource;
    static String host = "localhost";
    static String db = "test_spring_jdbc";
    static String port = "3306";
    static String user = "root";
    static String pwd = "root";
    static String conUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;

    static public DataSource getDataSource() {
        if (dataSource != null) return dataSource;

        MysqlDataSource _dataSource = new MysqlDataSource();
        _dataSource.setURL(conUrl);
        _dataSource.setUser(user);
        _dataSource.setPassword(pwd);

        dataSource = _dataSource;
        return dataSource;
    }
}
