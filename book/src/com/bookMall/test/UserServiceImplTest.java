package com.bookMall.test;

import com.bookMall.dao.UserDao;
import com.bookMall.dao.impl.UserDaoImpl;
import com.bookMall.pojo.User;
import com.bookMall.service.UserService;
import com.bookMall.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserService userService=new UserServiceImpl();

    @Test
    public void registUser() {
        User user=new User(null,"1111","1111","1111@qq.com");
        userService.registUser(user);
    }

    @Test
    public void login() {
        if(userService.login(new User(null,"1234","1234",null))!=null){
            System.out.println("登陆成功。");
        }else {
            System.out.println("登陆失败。");
        }
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("1234")){
            System.out.println("用户存在.");
        }else {
            System.out.println("用户不存在.");
        }
    }
}