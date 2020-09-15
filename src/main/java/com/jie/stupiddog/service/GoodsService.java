package com.jie.stupiddog.service;

import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.vo.GoodsVo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface GoodsService {

    //查询所有商品
    Map<String, List<GoodsAndImages>> findAll();

    //按照id查询商品
    GoodsAndImages findById(int goodsId);

    //按照goodsType_id查询商品
    Map<String, Object> findIfGoodsVo(GoodsVo goodsVo, int pageNum);

    //搜索
    Map<String, Object> searchGoods(GoodsVo goodsVo, int pageNum);

    //查询商品级别
    List<Goods> selectGrade();
}
