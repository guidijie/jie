package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;

import java.util.List;

public interface GoodsIdAndGoodsTypeDao {

    //查询所有商品id和商品类型id
    public List<GoodsIdAndGoodsType> findAll();

}
