package com.bookMall.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DruidDataSource druidDataSource;

    static {
        Properties  properties=new Properties();
        //读取jdbc.properties配置文件
        InputStream inputStream=JDBCUtils.class.getClassLoader().getResourceAsStream("com\\bookMall\\jdbc.properties");
        try {
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            druidDataSource= (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null则获取失败，反之则成功
     */
//    public static Connection getConnection(){
//        Connection con=null;
//        try {
//            con=druidDataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return con;
//    }

    public static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    /**
     * 获取进行事务处理的连接
     * @return
     */
    public static Connection getConnection(boolean transaction){
        if(transaction){
            Connection con=threadLocal.get();
            if(con==null){
                try {
                    con=druidDataSource.getConnection();
                    threadLocal.set(con);
                    con.setAutoCommit(false);//取消自动提交，开启事务
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return con;
        }else {
            Connection con=null;
            try {
                con=druidDataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return con;
        }

    }

    /**
     * 关闭连接，放回数据库连接池
     */
    public static void commitAndClose(){
        Connection con=threadLocal.get();
        if(con!=null){
            try {
                con.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static void rollBackAndClose(){
        Connection con=threadLocal.get();
        if(con!=null){
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            threadLocal.remove();
        }
    }

    public static void close(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
