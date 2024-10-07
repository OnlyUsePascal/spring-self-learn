package example.c04_data.cc03_spring_jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _Basics {
    DataSource dataSource = JDBCUtil.getDataSource();

    public void exec() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String query = "select * from Students";

        // row call back handler
        jdbcTemplate.query(query, (resultSet) -> {
            Student student = new Student(
                    resultSet.getString("name"),
                    resultSet.getInt("id")
            );
            // System.out.println(student);
        });

        // using row mapper, return a list
        jdbcTemplate.query(query, (resultSet, rowNum) -> {
            return new Student(
                    resultSet.getString("name"),
                    resultSet.getInt("id"));
        }).forEach(student -> {
            // System.out.println(student);
        });

        // return the whole thing
        List<Student> students = jdbcTemplate.query(query, new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Student> students = new ArrayList<>();
                while (resultSet.next()){
                    students.add(new Student(
                            resultSet.getString("name"),
                            resultSet.getInt("id")
                    ));
                }
                return students;
            }
        });
        students.forEach(student -> {
            // System.out.println(student);
        });

        // ONE-COLUMN QUERY
        query = "";
        Integer count = jdbcTemplate.queryForObject("select count(*) from Students", Integer.class);
        // System.out.println(count);

        jdbcTemplate.queryForList("select name from Students", String.class)
                .forEach(name -> {
                    // System.out.println(name);
                });
    }

}













