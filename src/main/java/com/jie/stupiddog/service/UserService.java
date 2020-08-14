package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.pojo.UserCourse;
import com.jie.stupiddog.pojo.UserInfo;

import java.util.List;

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

    /**
     * 修改密码
     * */
    public int changePassword(User user);


    /**
     * 我的课程
     * */
    public List<GoodsAndImages> findCourse(int id);
}
