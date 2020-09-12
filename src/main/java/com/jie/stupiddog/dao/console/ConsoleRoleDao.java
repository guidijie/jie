package com.jie.stupiddog.dao.console;

import com.jie.stupiddog.pojo.Role;
import com.jie.stupiddog.pojo.UserRole;

import java.util.List;

public interface ConsoleRoleDao {

    /**
     * 查询所有的角色
     * */
    List<Role> finAllRole();

    /**
     * 修改角色
     * */
    int byUserIdUpdateUserRole(UserRole userRole);
}
