package com.zs;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class SpringDataTest {

    private ApplicationContext ctx;

    @Before
    public void setup() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testEntityManagerFactory(){

    }
}
