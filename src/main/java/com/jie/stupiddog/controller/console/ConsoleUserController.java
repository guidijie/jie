package com.jie.stupiddog.controller.console;


import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.service.console.ConsoleUserService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/console")
@RestController
@CrossOrigin
public class ConsoleUserController {

    @Autowired
    ConsoleUserService consoleUserService;

    /**
     * 查询所有的用户信息
     * */
    @GetMapping("/findByUser")
    public ResponseMessage findByUser() {
        List<UserInfo> users = consoleUserService.findByUser();
        return users != null ? ResponseMessage.success().addObject("users",users) :
                ResponseMessage.error().addObject("msg","没有用户信息");
    }
}
