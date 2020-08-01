package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.pojo.UserInfo;

public interface UserService {
    /**
     * 查询用户
     * */
    public User findByUserName(String username);


    /**
     * 添加用户
     */
    public int addUser(User user);

    /**
     * 修改用户信息
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 查询用户信息
     */
    public UserInfo findByUserInfo(String username);

    /**
     * 判断密码是否正确
     * */
    public boolean isPassword(String username,String inputPassword);
}
