package com.bookMall.dao.impl;

import com.bookMall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//抽象类
//用来给其他类复用代码
public abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * update()方法用来用来执行insert、update、delete语句
     * @param sql sql语句
     * @param args 参数
     * @return 返回-1则执行失败，返回其它数则表示影响的行数
     */
    public int update(String sql,Object ... args){
        Connection con= JDBCUtils.getConnection(true);
        PreparedStatement ps=null;
        int count= -1;
        try {
            ps=con.prepareStatement(sql);
            for(int i=1;i<=args.length;i++){
                ps.setString(i,args[i-1].toString());
            }
            count = 0;
            count=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        return count;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数
     * @param <T> 返回类型的泛型
     * @return
     */
    public <T>T queryForOne(Class<T> type,String sql,Object ... args){
        Connection con=JDBCUtils.getConnection(false);
        try {
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtils.close(con);
        }
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数
     * @param <T> 返回类型的泛型的集合
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object ... args){
        Connection con=JDBCUtils.getConnection(false);
        try {
            return queryRunner.query(con,sql,new BeanListHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtils.close(con);
        }
    }

    /**
     * 返回一行一列的方法
     * @param sql 执行的sql语句1
     * @param args sql语句对应的参数
     * @return 返回对应结果
     */
    public Object queryForStringValue(String sql,Object ... args){
        Connection con=JDBCUtils.getConnection(false);
        try {
            return queryRunner.query(con,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            JDBCUtils.close(con);
        }
    }
}
