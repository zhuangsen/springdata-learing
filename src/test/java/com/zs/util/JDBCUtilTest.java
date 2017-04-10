package com.zs.util;

import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;


public class JDBCUtilTest {
    @Test
    public void getConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}