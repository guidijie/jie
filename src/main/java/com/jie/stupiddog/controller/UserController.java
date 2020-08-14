package com.jie.stupiddog.controller;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.pojo.UserCourse;
import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.service.UserService;
import com.jie.stupiddog.utils.ResponseMessage;
import com.jie.stupiddog.vo.UserInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    /**
     * 查询用户
     * */
    @GetMapping("/selectUser/{username}")
    @ResponseBody
    public ResponseMessage selectUser(@PathVariable String username){
        User user = userService.findByUserName(username);
        return user !=null ? ResponseMessage.success().addObject("user",user) : ResponseMessage.error();
    }

    /**
     * 添加用户
     * */
    @PostMapping("/addUser")
    @ResponseBody
    public ResponseMessage addUser(HttpServletRequest request){

        List<String> s = new ArrayList<>();
        //获取url并分离参数
        String queryString = request.getQueryString();
        String[] split = queryString.split("&");
        for (int i=0;i< split.length;i++){
            String[] split2 = split[i].split("=");
            for (int j=1;j< split2.length;j++){
                s.add(split2[j]);
            }
        }
        String username =s.get(0);
        String password=s.get(1) ;
        String rePassword=s.get(2);

        //判断两次密码是否相等
        if(password.equals(rePassword)){
            User user = new User(username,password,new Date(),new Date());
            int num = userService.addUser(user);
            System.out.println(num);
            return num >= 1 ?
                    ResponseMessage.success() :
                    ResponseMessage.error().addObject("error","用户已存在，请重新注册！");
        }
        return ResponseMessage.error().addObject("error","两次的密码不一致，请重新输入！");
    }

    /**
     * 查询用户
     * */
    @GetMapping("/findByUserInfo/{username}")
    @ResponseBody
    public ResponseMessage findByUserInfo(@PathVariable String username){
        UserInfo userInfo = userService.findByUserInfo(username);
        UserInfoVo userInfoVo = new UserInfoVo(userInfo);
        return userInfo != null ? ResponseMessage.success().addObject("userInfo",userInfoVo) :
                ResponseMessage.error().addObject("error","出错啦…………");
    }

    /**
     * 判断密码是否正确
     * */
    @GetMapping("/isPassword/{username}/{inputPassword}")
    @ResponseBody
    public ResponseMessage isPassword(@PathVariable String username , @PathVariable String inputPassword){
        boolean password = userService.isPassword(username, inputPassword);
        return password == true ? ResponseMessage.success().addObject("isPassword",password) :
                ResponseMessage.error().addObject("isPassword",password);
    }

    /**
     * 修改密码
     * */
    @PostMapping("/changePassword")
    @ResponseBody
    public ResponseMessage changePassword(@RequestBody User user){
        int num = userService.changePassword(user);
        return num >0 ? ResponseMessage.success().addObject("msg","密码更改成功,请重新登录") :
                ResponseMessage.error().addObject("msg","密码更改失败");
    }

    /**
     * 查询用户的课程
     * */
    @PostMapping("/findCourse/{userId}")
    @ResponseBody
    public ResponseMessage findCourse(@PathVariable int userId){
        List<GoodsAndImages> course = userService.findCourse(userId);
        return course != null ? ResponseMessage.success().addObject("course",course) :
                ResponseMessage.error().addObject("msg","用户暂时没有课程哦~");
    }
}
