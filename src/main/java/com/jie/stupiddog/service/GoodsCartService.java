package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.GoodsAndImages;

import java.util.List;

public interface GoodsCartService {

    //添加商品到购物车
    public int  addCart(int cid, int uid);

    //查询购物车
    public List<GoodsAndImages> findUserCart(String username);

    //删除购物车某一项商品
    public int deleteCart(int gId);
}
