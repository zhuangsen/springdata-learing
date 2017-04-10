package com.zs.repository;

import com.zs.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Before
    public void setup() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testPage(){
        //page:index从0开始
        Pageable pageable = new PageRequest(1,10);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询的总页数:"+page.getTotalPages());
        System.out.println("查询的总记录数:"+page.getTotalElements());
        System.out.println("查询的当前第几页:"+page.getNumber());
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("查询的当前页面的记录数:"+page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        //page:index从0开始
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询的总页数:"+page.getTotalPages());
        System.out.println("查询的总记录数:"+page.getTotalElements());
        System.out.println("查询的当前第几页:"+page.getNumber());
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("查询的当前页面的记录数:"+page.getNumberOfElements());
    }
}