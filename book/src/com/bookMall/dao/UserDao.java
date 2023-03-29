package com.bookMall.dao;

import com.bookMall.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null则没有该用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 用户密码
     * @return 返回null则用户名或密码错误，反之亦然
     */
    public User queryUserByUsername(String username,String password);

    /**
     * 保存用户信息
     * @param user 用户
     * @return 返回-1则保存失败，其它则成功
     */
    public int saveUser(User user);

    /**
     * 根据用户名查询用户id
     * @param username
     * @return
     */
    public int queryForUserId(String username);

}
