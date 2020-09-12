package com.jie.stupiddog.controller.console;


import com.jie.stupiddog.pojo.Role;
import com.jie.stupiddog.service.console.ConsoleRoleService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/role")
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class consoleRoleController {


    @Autowired
    private ConsoleRoleService consoleRoleService;
    /**
     * 查询所有的用户信息
     * */
    @GetMapping("/findAllRole")
    public ResponseMessage findAllRole() {
        List<Role> roles = consoleRoleService.finAllRole();
        return roles != null ? ResponseMessage.success().addObject("roles",roles) :
                ResponseMessage.error().addObject("msg","错误");
    }
}
