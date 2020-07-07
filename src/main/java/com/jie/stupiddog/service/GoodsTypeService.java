package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    //查询商品的类型
    public List<GoodsType> selectGoodsType();
}
