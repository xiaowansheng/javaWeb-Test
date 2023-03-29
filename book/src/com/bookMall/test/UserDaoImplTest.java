package com.bookMall.test;

import com.bookMall.dao.UserDao;
import com.bookMall.dao.impl.UserDaoImpl;
import com.bookMall.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao=new UserDaoImpl();
        User user=userDao.queryUserByUsername("admin");
        if(user!=null){
            System.out.println("用户存在。");
            System.out.println(user);
        }else{
            System.out.println("用户不存在");
        }
    }

    @Test
    public void testQueryUserByUsername() {
        UserDao userDao=new UserDaoImpl();
        User user=userDao.queryUserByUsername("admin","admin");
        if(user!=null){
            System.out.println("账号密码正确。");
            System.out.println(user);
        }else{
            System.out.println("账号或密码错误");
        }

    }

    @Test
    public void saveUser() {
        UserDao userDao=new UserDaoImpl();
        User user=new User(null,"1234","1234","1234@qq.com");
        int count=userDao.saveUser(user);
        if(count!=-1){
            System.out.println("注册成功。");
            System.out.println(user);
        }else{
            System.out.println("注册失败。");
        }
    }
}