package com.jie.stupiddog.dao.console;

import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
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

    /**
     * 添加商品类型
     * */
    int addGoodsType(GoodsType goodsType);

    /**
     * 修改商品类型
     * */
    int updateGoodsType(GoodsType goodsType);

    /**
     * 查询所有商品
     * */
    List<GoodsAndImages> findGoodsAll();

    /**
     * 根据goodsId更新goods信息
     * */
    int updateGoods(Goods goods);

    /**
     * 根据goodsId删除goods
     * */
    int deleteGoods(int goodsId);

    /**
     * 根据goodsId删除goods_id_type
     * */
    int deleteGoodsIdType(int goodsId);

    /**
     * 批量删除goods
     * */
    int deleteGoodsList(List<Goods> goodsList);

    /**
     * 批量删除goods_id_type
     * */
    int deleteGoodsIdTypeList(List<Goods> goodsList);

}
