package com.jie.stupiddog.controller;

import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.service.GoodsService;
import com.jie.stupiddog.utils.ResponseMessage;
import com.jie.stupiddog.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
        GoodsAndImages goodsAndImages = goodsService.findById(id);
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
        GoodsVo goodsVo = new GoodsVo(goodsType,level,"");
        Map<String, Object> levelMap = goodsService.findIfGoodsVo(goodsVo, pageNum);
        return levelMap != null ?
                ResponseMessage.success().addObject("goods", levelMap) :
                ResponseMessage.error();

    }

    /*搜索商品*/
    @PostMapping("/searchGoods/{pageNum}")
    @ResponseBody
    public ResponseMessage searchGoods(@PathVariable int pageNum,@RequestBody GoodsVo goodsVo) {
        System.out.println(pageNum+"   "+goodsVo.toString());
        Map<String, Object> levelMap = goodsService.searchGoods(goodsVo, pageNum);
        return levelMap != null ?
                ResponseMessage.success().addObject("goods", levelMap) :
                ResponseMessage.error();

    }


//
}
