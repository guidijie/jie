package com.jie.stupiddog.dao.console;

import com.jie.stupiddog.pojo.UserInfo;

import java.util.List;

public interface ConsoleUserDao {

    /**
     * 查询所有用户信息
     * */
    List<UserInfo> findByUser();
}
