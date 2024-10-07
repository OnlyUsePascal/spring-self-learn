package example.c04_data.cc03_spring_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;

public class _PreparedStatement {
    DataSource dataSource = JDBCUtil.getDataSource();

    public void execJdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "select * from Students where name like ? and id >= ?";

        template.query(query, (rs) -> {
            Student st = new Student(
                    rs.getString("name"),
                    rs.getInt("id")
            );
            System.out.println(st);
        }, "jo%", 1);
    }

    public void execNamedTemplate() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String query = "select * from Students where name like :name and id >= :id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", "jo%")
                .addValue("id", 1);

        template.query(query, params, (rs) -> {
            Student st = new Student(
                    rs.getString("name"),
                    rs.getInt("id")
            );
            System.out.println(st);
        });
    }
}
