package com.jie.stupiddog.controller;

import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.GoodsService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    /*主页*/
    @RequestMapping({"/index","/","/index.html"})
    public String hello(HttpSession session){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if("anonymousUser".equals(principal)) {
            session.setAttribute("uname",null);
        }else {
            User user = (User)principal;
            session.setAttribute("uname",user.getUsername());
            session.setMaxInactiveInterval(60 * 30);
        }

        return "front_desk/index";
    }

    /*头部*/
    @RequestMapping("/header")
    public String header(){
        return "/front_desk/publicpage/header";
    }

    /*头部*/
    @RequestMapping("/footer")
    public String footer(){
        return "/front_desk/publicpage/footer";
    }

    /*登录页*/
    @RequestMapping({"/login.html","toLogin"})
    public String toLogin(){
        return "front_desk/login";
    }
    /*注册页*/
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "front_desk/register";
    }
    /*忘记密码*/
    @RequestMapping("/toForgotPwd")
    public String toForgotPwd(){
        return "front_desk/Forgot-Password";
    }

    /*购物车页*/
    @RequestMapping({"/toCart","/cart.html"})
    public String toCart(){
        return "front_desk/cart";
    }

    /*购物车页*/
    @RequestMapping({"/toGoods","/goods.html"})
    public String goods(){
        return "front_desk/goods";
    }

    /*商品分类页*/
    @RequestMapping("/toCourseClassification")
    public String toCourseClassification(){
        return "front_desk/course-classification";
    }

    /* 我的信息 */
    @RequestMapping("/me.html")
    public String me(){
        return "/front_desk/me";
    }

    /* 我的订单 */
    @RequestMapping("/myorder.html")
    public String myOrder(){
        return "/front_desk/myorder";
    }

    /* 我的课程 */
    @RequestMapping("/mycourse.html")
    public String myCourse(){
        return "/front_desk/mycourse";
    }

    /* 修改密码 */
    @RequestMapping("/Change-p.html")
    public String ChangePwd(){
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
    public ResponseMessage findAll(){
        Map<String, List<GoodsAndImages>> stringListMap = goodsService.selectByIds();
        return  stringListMap != null ? ResponseMessage.success().addObject("goodsAll",stringListMap)
                : ResponseMessage.error().addObject("error","请求失败了~");
    }

//
}
