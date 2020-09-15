package com.jie.stupiddog.controller;


import ch.qos.logback.core.util.FileUtil;
import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.service.GoodsService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@CrossOrigin
public class IndexController {
    /*主页*/
    @RequestMapping({"/index", "/", "/index.html"})
    public String hello(HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ("anonymousUser".equals(principal)) {
            session.setAttribute("uname", null);
        } else {
            User user = (User) principal;
            session.setAttribute("uname", user.getUsername());
            session.setMaxInactiveInterval(60 * 30);
        }

        return "front_desk/index";
    }

    /*头部*/
    @RequestMapping("/header")
    public String header() {
        return "/front_desk/publicpage/header";
    }

    /*底部*/
    @RequestMapping("/footer")
    public String footer() {
        return "/front_desk/publicpage/footer";
    }

    /*登录页*/
    @RequestMapping({"/login.html", "toLogin"})
    public String toLogin() {
        return "front_desk/login";
    }

    /*注册页*/
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "front_desk/register";
    }

    /*忘记密码*/
    @RequestMapping("/toForgotPwd")
    public String toForgotPwd() {
        return "front_desk/Forgot-Password";
    }

    /*搜索*/
    @RequestMapping("/toSearch")
    public String toSearch() {
        return "front_desk/search";
    }

    /*购物车页*/
    @RequestMapping({"/toCart", "/cart.html"})
    public String toCart() {
        return "front_desk/cart";
    }

    /*购物车页*/
    @RequestMapping({"/toGoods", "/goods.html"})
    public String goods() {
        return "front_desk/goods";
    }

    /*商品分类页*/
    @RequestMapping("/toCourseClassification")
    public String toCourseClassification() {
        return "front_desk/course-classification";
    }

    /* 我的信息 */
    @RequestMapping("/me.html")
    public String me() {
        return "/front_desk/me";
    }

    /* 我的订单 */
    @RequestMapping("/myorder.html")
    public String myOrder() {
        return "/front_desk/myorder";
    }

    /* 我的课程 */
    @RequestMapping("/mycourse.html")
    public String myCourse() {
        return "/front_desk/mycourse";
    }

    /* 修改密码 */
    @RequestMapping("/Change-p.html")
    public String ChangePwd() {
        return "/front_desk/Change-p";
    }


    @Resource
    public GoodsService goodsService;
    @Resource
    public GoodsTypeDao goodsTypeDao;
    @Resource
    public GoodsDao goodsDao;


    /*查询所有商品数据*/
    @GetMapping("/findAll")
    @ResponseBody
    public ResponseMessage findAll() {
        Map<String, List<GoodsAndImages>> goodsList = goodsService.findAll();
        return goodsList != null ? ResponseMessage.success().addObject("goodsAll", goodsList)
                : ResponseMessage.error().addObject("error", "请求失败了~");
    }

    //
    @PostMapping("/xiazai")
    @ResponseBody
    public ResponseMessage xiazai(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "price", required = false) String price,
                                  @RequestParam(value = "preferential", required = false) String preferential,
                                  @RequestParam(value = "grade", required = false) String grade,
                                  @RequestParam(value = "typeName", required = false) String typeName,
                                  @RequestParam(value = "goodsImg", required = false) String goodsImg,
                                  @RequestParam(value = "introduction", required = false) String introduction,
                                  @RequestParam(value = "details", required = false) String details,
                                  @RequestParam(value = "directory", required = false) String directory,
                                  @RequestParam(value = "delivery", required = false) String delivery,
                                  @RequestParam(value = "file", required = false) MultipartFile file,
                                  HttpServletRequest request
    ) throws IOException {
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
        File file1 = new File(uri + "\\src\\main\\resources\\static\\images\\goodsImage", filename);

        //将接收的到的 multipartFile 类型的文件 转为 file
        file.transferTo(file1);
        //获取接收到的并存在项目本地的文件，这样你就可以拿着这个文件随意处理啦
        String filePath = file1.getAbsolutePath();
        //        return filePath ;
        return null;
    }

}
