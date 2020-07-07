package com.jie.stupiddog.controller;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.service.GoodsCartService;
import com.jie.stupiddog.service.GoodsTypeService;
import com.jie.stupiddog.service.UserService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GoodsCartController {
    @Resource
    UserService userService;

    @Resource
    GoodsCartService goodsCartService;


    @GetMapping("/cart/{goodsId}/{username}")
    @ResponseBody
    public ResponseMessage addCart(@PathVariable String goodsId,@PathVariable String username ){
        System.out.println(goodsId +"  "+ username);
        Integer integer = Integer.valueOf(goodsId);
        User user = userService.findByUserName(username);
        int addCart = goodsCartService.addCart(integer, user.getId());
        if(addCart == 0){
            return ResponseMessage.error().addObject("msg","购物车已存在改商品！");
        }
        return addCart > -1 ? ResponseMessage.success().addObject("msg","商品成功添加到了购物车"):
                ResponseMessage.error().addObject("msg","商品添加失败了！");
    }

    @GetMapping("/cart/{username}")
    @ResponseBody
    public ResponseMessage addCart(@PathVariable String username ){
        List<GoodsAndImages> userCart = goodsCartService.findUserCart(username);
        return userCart != null ? ResponseMessage.success().addObject("userCart",userCart) :
                ResponseMessage.error().addObject("msg","购物车暂无商品");
    }

    @GetMapping("/cart/delete/{gId}")
    @ResponseBody
    public ResponseMessage deleteCart(@PathVariable String gId ){
        Integer integer = Integer.valueOf(gId);
        int num = goodsCartService.deleteCart(integer);
        return num > -1 ? ResponseMessage.success().addObject("msg","删除成功") :
                ResponseMessage.error().addObject("msg","删除失败");
    }
}
