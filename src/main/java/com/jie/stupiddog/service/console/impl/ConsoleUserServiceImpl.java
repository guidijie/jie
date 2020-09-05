package com.jie.stupiddog.service.console.impl;

import com.jie.stupiddog.dao.console.ConsoleUserDao;
import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.service.console.ConsoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleUserServiceImpl implements ConsoleUserService {

    @Autowired
    private ConsoleUserDao consoleUserDao;


    /**
     * 查询所有的用户信息
     * */
    @Override
    public List<UserInfo> findByUser() {
        return consoleUserDao.findByUser();
    }
}
