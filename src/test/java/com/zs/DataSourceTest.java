package com.zs;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {

    private ApplicationContext ctx;

    @Before
    public void setup() {
        System.out.println("set up");
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testDataSource() {
        System.out.println("test dataSource");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println("test jdbcTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
    }
}
