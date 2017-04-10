package com.zs.service;

import com.zs.domain.Employee;
import com.zs.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceTest {

    private ApplicationContext ctx;
    private EmployeeService employeeService;

    @Before
    public void setup() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testUpdate(){
        employeeService.update(1,25);
    }

    @Test
    public void testSave() throws Exception {
        List<Employee> employees = new ArrayList<>();

        Employee employee = null;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test"+i);
            employee.setAge(100-i);
            employees.add(employee);
        }

        employeeService.save(employees);
    }
}