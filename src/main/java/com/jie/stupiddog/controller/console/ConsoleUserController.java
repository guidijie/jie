package com.jie.stupiddog.controller.console;


import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.pojo.UserRole;
import com.jie.stupiddog.service.UserService;
import com.jie.stupiddog.service.console.ConsoleRoleService;
import com.jie.stupiddog.service.console.ConsoleUserService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/console")
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class ConsoleUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ConsoleUserService consoleUserService;
    @Autowired
    private ConsoleRoleService consoleRoleService;

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

    /**
     * 修改用户密码
     * */
    @PostMapping("/changePW")
    public ResponseMessage ChangePW(@RequestBody User user) {
        int changePassword = userService.changePassword(user);
        return changePassword > 0 ? ResponseMessage.success().addObject("msg","修改成功") :
                ResponseMessage.error().addObject("msg","修改失败");
    }

    @PostMapping("/updateUserInfo")
    public ResponseMessage updateUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setModifytime(new Date());
        int info = userService.updateUserInfo(userInfo);
        if(info > 0){
            int roleId = 0;
            if (userInfo.getRole().equals("超级管理员")){
                roleId = 1;
            }else if(userInfo.getRole().equals("普通用户")){
                roleId = 2;
            }else {
                return  info > 0  ? ResponseMessage.success().addObject("msg", "修改成功") :
                        ResponseMessage.error().addObject("msg", "錯誤");
            }
            UserRole userRole = new UserRole(userInfo.getUserId(),roleId);
            int u = consoleUserService.updateRoleId(userRole);
            int r = consoleRoleService.byUserIdUpdateUserRole(userRole);

            return  (u >0) && (r > 0)  ? ResponseMessage.success().addObject("msg", "修改成功") :
                    ResponseMessage.error().addObject("msg", "錯誤");
        }
        System.out.println(userInfo.toString());
        return null;
    }
}
