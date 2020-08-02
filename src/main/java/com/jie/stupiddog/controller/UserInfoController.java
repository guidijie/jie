package com.jie.stupiddog.controller;

import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.service.UserService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    UserService userService;

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public ResponseMessage updateUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setModifytime(new Date());
        int info = userService.updateUserInfo(userInfo);
        System.out.println(userInfo.toString());
        return info >0 ? ResponseMessage.success().addObject("info", "修改成功") :
                ResponseMessage.error().addObject("info", "錯誤");
    }
}
