package com.zs.repository;

import com.zs.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeJpaRepostoryTest {

    private ApplicationContext ctx;
    private EmployeeJpaRepostory employeeJpaRepostory;

    @Before
    public void setUp() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepostory = ctx.getBean(EmployeeJpaRepostory.class);
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testFind(){
        Employee employee = employeeJpaRepostory.findOne(99);
        System.out.println("employee id=99:"+employee);
        System.out.println("employee exits(10):"+employeeJpaRepostory.exists(10));
        System.out.println("employee exits(102):"+employeeJpaRepostory.exists(102));
    }
}