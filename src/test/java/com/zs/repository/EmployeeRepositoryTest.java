package com.zs.repository;

import com.zs.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class EmployeeRepositoryTest {
    private ApplicationContext ctx;
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testFindByName() throws Exception {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee);
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() throws Exception {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() throws Exception{
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6",22);
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameInOrAgeLessThan() throws Exception{
        List<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,22);
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployeeByMaxId() throws Exception{
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee);
    }

    @Test
    public void testQueryParams1() throws Exception{
        List<Employee> employees = employeeRepository.queryParams1("zhangsan",20);
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryParams2() throws Exception{
        List<Employee> employees = employeeRepository.queryParams1("zhangsan",20);
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryLike1() throws Exception{
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryLike2() throws Exception{
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testGetCount() throws Exception{
        long count = employeeRepository.getCount();
        System.out.println(count);
    }

    @Test
    public void testUpdate(){
        employeeRepository.update(1,55);
    }
}