package com.jie.stupiddog.service.console.impl;

import com.jie.stupiddog.dao.console.ConsoleRoleDao;
import com.jie.stupiddog.pojo.Role;
import com.jie.stupiddog.pojo.UserRole;
import com.jie.stupiddog.service.console.ConsoleRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsoleRoleServiceImpl implements ConsoleRoleService {

    @Autowired
    private ConsoleRoleDao consoleRoleDao;


    /**
     * 查询所有的角色
     * */
    @Override
    public List<Role> finAllRole() {
        return consoleRoleDao.finAllRole();
    }

    /**
     * 修改角色
     * */
    @Override
    public int byUserIdUpdateUserRole(UserRole userRole) {
        return consoleRoleDao.byUserIdUpdateUserRole(userRole);
    }
}
