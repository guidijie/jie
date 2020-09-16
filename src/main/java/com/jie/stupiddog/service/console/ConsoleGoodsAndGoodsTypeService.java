package com.jie.stupiddog.service.console;


import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsoleGoodsAndGoodsTypeService {

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
