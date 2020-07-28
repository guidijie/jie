package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.GoodsCart;

import java.util.List;

public interface GoodsCartDao {

    /**
     * 添加商品到购物车
     * */
    public int addCart(GoodsCart goodsCart);

    /**
     * 查询商品是否存在
     * */
    public GoodsCart findGoods(GoodsCart goodsCart);


    /**
     * 查询用户购物车的商品
     * */
    public List<GoodsCart> findUserCart(int userId);

    /**
     * 删除购物车商品
     */
    public int deleteCart(GoodsCart goodsCart);
}
