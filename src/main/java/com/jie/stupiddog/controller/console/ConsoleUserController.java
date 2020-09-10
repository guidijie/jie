package com.jie.stupiddog.controller.console;


import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.service.console.ConsoleUserService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/console")
@RestController
@CrossOrigin
public class ConsoleUserController {

    @Autowired
    ConsoleUserService consoleUserService;

    /**
     * 查询所有的用户信息
     * */
    @GetMapping("/findByUser/{num}")
    public ResponseMessage findByUser(@PathVariable String num) {
        Integer pageNum = Integer.valueOf(num);
        Map<String, Object> userMap = consoleUserService.findByUser(pageNum);
        return userMap != null ? ResponseMessage.success().addObject("users",userMap) :
                ResponseMessage.error().addObject("msg","没有用户信息");
    }
}
