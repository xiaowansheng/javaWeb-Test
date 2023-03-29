package com.bookMall.test;

import com.bookMall.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilsTest {
    @Test
    public void jdbcTest(){
        Connection con=null;
        for(int i=0;i<100;i++){
            con= JDBCUtils.getConnection(false);
            System.out.println(con);
            JDBCUtils.close(con);
        }
    }
}
