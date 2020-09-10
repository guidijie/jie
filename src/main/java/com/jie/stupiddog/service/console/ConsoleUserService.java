package com.jie.stupiddog.service.console;

import com.jie.stupiddog.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface ConsoleUserService {

    /**
     * 查询所有用户信息
     * */
    Map<String, Object> findByUser(int pageNum);
}
