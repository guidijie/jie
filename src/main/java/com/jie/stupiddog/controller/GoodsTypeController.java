package com.jie.stupiddog.controller;

import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.GoodsTypeService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Resource
    private GoodsTypeService goodsTypeService;

    @GetMapping("/selectGoodsType")
    @ResponseBody
    public ResponseMessage selectGoodsType(){
        List<GoodsType> goodsTypes = goodsTypeService.selectGoodsType();
        return goodsTypes !=  null ?
                ResponseMessage.success().addObject("goodsTypes",goodsTypes) :
                ResponseMessage.error();
    }
}
