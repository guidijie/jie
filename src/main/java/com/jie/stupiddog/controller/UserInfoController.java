package com.jie.stupiddog.controller;

import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public ResponseMessage updateUserInfo(@RequestBody UserInfo userInfo){

        System.out.println(userInfo.toString());
//        return orderVOList != null ? ResponseMessage.success().addObject("orderGoodsList", orderVOList) :
//                ResponseMessage.error().addObject("msg", "錯誤");
        return ResponseMessage.success();
    }
}
