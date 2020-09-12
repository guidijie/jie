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
}
