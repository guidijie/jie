package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.GoodsImages;

import java.util.List;

public interface GoodsImagesDao {

    //查询所有商品图片
    public List<GoodsImages> findAll();

    //按照商品id查询商品图片
    public List<GoodsImages> findById(int id);


}
