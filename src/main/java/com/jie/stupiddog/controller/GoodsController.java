package com.jie.stupiddog.controller;

import com.github.pagehelper.PageHelper;
import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.GoodsAndImagesService;
import com.jie.stupiddog.service.GoodsService;
import com.jie.stupiddog.utils.ResponseMessage;
import com.jie.stupiddog.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    public GoodsService goodsService;
    @Resource
    public GoodsTypeDao goodsTypeDao;
    @Resource
    public GoodsDao goodsDao;
    @Resource
    public GoodsAndImagesService goodsAndImagesService;

    @GetMapping("/toPay")
    public String toPay(){
        return "front_desk/pay";
    }

    /* 查询商品级别 */
    @GetMapping("/selectGrade")
    @ResponseBody
    public ResponseMessage selectGrade() {
        List<Goods> goods = goodsService.selectGrade();
        return goods != null ?
                ResponseMessage.success().addObject("grade", goods) :
                ResponseMessage.error();
    }

    /*按照商品id查询*/
    @GetMapping("/findGoodsId/{id}")
    @ResponseBody
    public ResponseMessage findGoodsId(@PathVariable int id) {
        System.out.println(id);
        GoodsAndImages goodsAndImages = goodsAndImagesService.findAllGoodsId(id);
        return goodsAndImages != null ?
                ResponseMessage.success().addObject("goods", goodsAndImages) :
                ResponseMessage.error();
    }

    /*按照GoodsVo对象查询商品*/
    @GetMapping("/findGoodsType/{goodsType}/{level}/{pageNum}")
    @ResponseBody
    public ResponseMessage findGoodsType(@PathVariable String goodsType, @PathVariable String level, @PathVariable int pageNum) {
        if (level.equals("undefined")) {
            level = "all";
        }
        System.out.println(goodsType + "  " + level + "   " + pageNum);
        GoodsVo goodsVo = new GoodsVo(goodsType,level);
        Map<String, Object> levelMap = goodsAndImagesService.findIfGoodsVo(goodsVo, pageNum);
        return levelMap != null ?
                ResponseMessage.success().addObject("goods", levelMap) :
                ResponseMessage.error();

    }


//
}
