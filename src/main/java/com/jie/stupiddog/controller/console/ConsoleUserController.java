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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     */
    @GetMapping("/findByUser/{num}")
    public ResponseMessage findByUser(@PathVariable String num) {
        Integer pageNum = Integer.valueOf(num);
        Map<String, Object> userMap = consoleUserService.findByUser(pageNum);
        return userMap != null ? ResponseMessage.success().addObject("users", userMap) :
                ResponseMessage.error().addObject("msg", "没有用户信息");
    }

    /**
     * 修改用户密码
     */
    @PostMapping("/changePW")
    public ResponseMessage ChangePW(@RequestBody User user) {
        int changePassword = userService.changePassword(user);
        return changePassword > 0 ? ResponseMessage.success().addObject("msg", "修改成功") :
                ResponseMessage.error().addObject("msg", "修改失败");
    }


    /**
     * 修改用户信息
     */
    @PostMapping("/updateUserInfo")
    public ResponseMessage updateUserInfo(@RequestBody UserInfo userInfo) {
        userInfo.setModifytime(new Date());
        int info = userService.updateUserInfo(userInfo);
        if (info > 0) {
            int roleId = 0;
            if (userInfo.getRole().equals("超级管理员")) {
                roleId = 1;
            } else if (userInfo.getRole().equals("普通用户")) {
                roleId = 2;
            } else {
                return info > 0 ? ResponseMessage.success().addObject("msg", "修改成功") :
                        ResponseMessage.error().addObject("msg", "錯誤");
            }
            UserRole userRole = new UserRole(userInfo.getUserId(), roleId);
            int u = consoleUserService.updateRoleId(userRole);
            int r = consoleRoleService.byUserIdUpdateUserRole(userRole);

            return (u > 0) && (r > 0) ? ResponseMessage.success().addObject("msg", "修改成功") :
                    ResponseMessage.error().addObject("msg", "錯誤");
        }
        System.out.println(userInfo.toString());
        return null;
    }

    /**
     * 删除用户
     */
    @GetMapping("/deleteUser/{id}")
    public ResponseMessage updateUserInfo(@PathVariable int id) {

        int num1 = consoleUserService.deleteUserId(id);
        if (num1 > 0) {
            int num2 = consoleUserService.deleteUserInfoId(id);
            if (num2 > 0) {
                int num3 = consoleRoleService.deleteUserRoleId(id);
                if (num3 > 0) {
                    int num4 = consoleUserService.deleteUserCourseId(id);
                    return num3 > 0 && num4 >= 0 ? ResponseMessage.success().addObject("msg", "删除成功") :
                            ResponseMessage.error().addObject("msg", "錯誤");
                }
            }
        }

        return null;
    }

    /**
     * 上传用户头像
     */
    //
    @PostMapping("/uploadUserImg")
    public ResponseMessage uploadUserImg(
            @RequestParam(value = "userId", required = false) int userId,
            @RequestParam(value = "fileImage", required = false) MultipartFile file,
            HttpServletRequest request
    ) throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.setModifytime(new Date());
        userInfo.setUserId(userId);
        userInfo.setImagePath(uploadImage(file));

        int num = consoleUserService.updateUserImage(userInfo);
        System.out.println(num);
        return null;
    }








    private static String uploadImage(MultipartFile file) throws IOException {

        String IMAGEPATH = "\\images\\userImages\\";
        //获取前端上传的文件名称
        String multifilename = file.getOriginalFilename();
        //取文件名下标，给文件重命名的时候使用
        String suffix = multifilename.substring(multifilename.indexOf("."));
        //取一个随机id给文件重命名使用
        String uuid = UUID.randomUUID().toString();
        //你的接收的文件新的名字
        String filename = uuid + suffix;
        //获取项目的绝对路径
        String uri = System.getProperty("user.dir");
        //在项目新建一个 你重新生成名称的文件
        File file1 = new File(uri + "\\src\\main\\resources\\static\\images\\userImages", filename);

        //将接收的到的 multipartFile 类型的文件 转为 file
        file.transferTo(file1);
        //获取接收到的并存在项目本地的文件，这样你就可以拿着这个文件随意处理啦
        String filePath = file1.getAbsolutePath();

        return IMAGEPATH + filename;
    }
}
