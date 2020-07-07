package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeDao {

    //查询所有的商品类型
    public List<GoodsType> findAll();

    //根据name查询商品类型
    public GoodsType findByGoodsTypeName(String name);

    //按照商品类型id查询商品
    public List<GoodsIdAndGoodsType> findByGoodsTypeId(int id);
}
