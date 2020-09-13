package com.jie.stupiddog.service.console;


import com.jie.stupiddog.pojo.Role;
import com.jie.stupiddog.pojo.UserRole;

import java.util.List;

public interface ConsoleRoleService {

    /**
     * 查询所有角色
     * */
    List<Role> finAllRole();

    /**
     * 修改角色
     * */
    int byUserIdUpdateUserRole(UserRole userRole);

    /**
     * 用户被删除后删除用户对应角色
     * */
    int deleteUserRoleId(int userId);
}
