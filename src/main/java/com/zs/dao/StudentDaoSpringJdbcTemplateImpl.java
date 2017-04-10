package com.zs.dao;


import com.zs.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoSpringJdbcTemplateImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {
        List<Student> students = new ArrayList<>();
        String sql = "select id, name , age from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student(name, age);
                student.setId(id);

                students.add(student);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student(name, age) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
