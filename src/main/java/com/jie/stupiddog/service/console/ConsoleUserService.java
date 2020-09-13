package com.jie.stupiddog.service.console;

import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.pojo.UserRole;

import java.util.List;
import java.util.Map;

public interface ConsoleUserService {

    /**
     * 查询所有用户信息
     * */
    Map<String, Object> findByUser(int pageNum);

    /**
     * 修改user中的role_id
     * */
    int updateRoleId(UserRole userRole);


    /**
     * 删除用户
     * */
    int deleteUserId(int id);

    /**
     * 删除用户信息
     * */
    int deleteUserInfoId(int userId);

    /**
     * 删除用户课程
     * */
    int deleteUserCourseId(int userId);

    /**
     * 修改用户头像
     * */
    int updateUserImage(UserInfo userInfo);
}
