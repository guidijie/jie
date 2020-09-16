package com.jie.stupiddog.dao.console;

import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;

import java.util.List;

public interface ConsoleGoodsAndGoodsTypeDao {

    /**
     * 查询所有goodsType
     * */
    List<GoodsType> findGoodsTypeAll();

    /**
     * 添加商品
     * */
    int addGoods(Goods goods);

    /**
     * 给商品添加对应商品类型
     * */
    int giveGoodsAddGoodsType(GoodsIdAndGoodsType goodsIdAndGoodsType);

}
