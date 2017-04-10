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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;


public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository;

    @Before
    public void setUp() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    /**
     * 1.分页
     * 2.排序
     * 3.查询条件:age>50
     */
    @Test
    public void testQuery(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        //page:index从0开始
        Pageable pageable = new PageRequest(0,5,sort);

        /**
         * root：就是我们要查询的类型(Employee)
         * query:查询条件
         * cb:构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //root(employee(age))
                Path path = root.get("age");
                return cb.gt(path,50);
            }
        };

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
        System.out.println("查询的总页数:"+page.getTotalPages());
        System.out.println("查询的总记录数:"+page.getTotalElements());
        System.out.println("查询的当前第几页:"+page.getNumber());
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("查询的当前页面的记录数:"+page.getNumberOfElements());
    }
}