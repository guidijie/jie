package com.jie.stupiddog.service.console;

import com.jie.stupiddog.pojo.UserInfo;

import java.util.List;

public interface ConsoleUserService {

    /**
     * 查询所有用户信息
     * */
    List<UserInfo> findByUser();
}
