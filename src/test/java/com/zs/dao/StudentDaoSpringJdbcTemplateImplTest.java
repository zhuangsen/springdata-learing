package com.zs.dao;

import com.zs.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;


public class StudentDaoSpringJdbcTemplateImplTest {
    private ApplicationContext ctx;
    private StudentDao studentDao;

    @Before
    public void setup() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao) ctx.getBean("studentDao");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testQuery() throws Exception {
        List<Student> students = studentDao.query();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSave() throws Exception {
        Student student = new Student("test-spring-jdbc", 40);
        studentDao.save(student);
    }

}