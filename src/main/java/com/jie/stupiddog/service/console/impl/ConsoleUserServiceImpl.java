package com.jie.stupiddog.service.console.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jie.stupiddog.dao.console.ConsoleUserDao;
import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.pojo.UserRole;
import com.jie.stupiddog.service.console.ConsoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsoleUserServiceImpl implements ConsoleUserService {

    @Autowired
    private ConsoleUserDao consoleUserDao;


    /**
     * 查询所有的用户信息
     * */
    @Override
    public Map<String, Object> findByUser(int pageNum) {
        Map<String, Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, 20);
        List<UserInfo> byUser = consoleUserDao.findByUser();
        map.put("users",byUser);
        //封装自定义的page类
        long total = page.getTotal();
        com.jie.stupiddog.utils.Page page1 = new com.jie.stupiddog.utils.Page();
        page1.setTotal(total);
        map.put("page",page1);
        return map;
    }

    /**
     * 修改user中的role_id
     * */
    @Override
    public int updateRoleId(UserRole userRole) {
        return consoleUserDao.updateRoleId(userRole);
    }
}
