package com.jie.stupiddog.service;

import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsType;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface GoodsService {

    //查询所有商品
    public Map<String,List<Goods>> findAll();

    //按照id查询商品
    public List<Goods> findById(int goodsId);

    //按照goodsType_id查询商品
    public Map<String,List<GoodsAndImages>> selectByIds();


    //查询商品级别
    public List<Goods> selectGrade();
}
