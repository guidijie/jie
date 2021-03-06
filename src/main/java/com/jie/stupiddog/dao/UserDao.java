package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 查询用户
     * */
    public User findByUserName(String username);

    /**
     * 查询用户信息
     * */
    public UserInfo findByUserInfo(int uId);

    /**
    * 添加用户
    */
     public int addUser(User user);

    /**
    * 添加用户
    */
     public int addUserInfo(UserInfo userInfo);

     /**
     * 添加用户
     */
     public int updateUserInfo(UserInfo userInfo);

     /**
      * 按照用户密码查询
      * */
     public User findByPassword(String encodedPassword);

     /**
      * 将商品添加到用户课程里面
      * */
     public int addGoodsToCourse(@Param("userCourseList") List<UserCourse> userCourseList);

     /**
      * 付款
      * */
     public int pay(Order order);


     /**
      * 修改密码
      * */
     public int changePassword(User user);

     /**
      * 查询我的课程
      * */
     public List<UserCourse> findCourse(int goodsId);




}
