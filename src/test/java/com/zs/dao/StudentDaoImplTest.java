package com.zs.dao;

import com.zs.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    @Test
    public void testQuery() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.query();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSave() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student("test", 30);
        studentDao.save(student);
    }

}