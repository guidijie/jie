package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.vo.GoodsVo;

import java.util.List;

public interface GoodsAndImagesDao {

    //展示所有商品
    public List<GoodsAndImages> findAll();

    //按照goods_id插叙
    public GoodsAndImages findGoodsId(int id);

    //按照grade查询
    public List<GoodsAndImages> findGrade(String level);

    //goodsvo类条件查询
    public List<GoodsAndImages> findIfGoodsVo(GoodsVo gv);

    //查询购物车商品
    public GoodsAndImages findByGoodsID(int goodsId);
}
