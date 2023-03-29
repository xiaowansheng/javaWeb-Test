package com.bookMall.dao.impl;

import com.bookMall.dao.UserDao;
import com.bookMall.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql="select id,username,password,email from tb_users where username=?;";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsername(String username, String password) {
        String sql="select id,username,password,email from tb_users where username=? and password=?;";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into tb_users(username,password,email) values(?,?,?);";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public int queryForUserId(String username) {
        String sql="select id from tb_users where username=?;";
        return (Integer) queryForStringValue(sql,username);
    }
}
