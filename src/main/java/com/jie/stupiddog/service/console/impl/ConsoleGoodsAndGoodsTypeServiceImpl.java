package com.jie.stupiddog.service.console.impl;

import com.jie.stupiddog.dao.console.ConsoleGoodsAndGoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.console.ConsoleGoodsAndGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleGoodsAndGoodsTypeServiceImpl implements ConsoleGoodsAndGoodsTypeService {

    @Autowired
    private ConsoleGoodsAndGoodsTypeDao consoleGoodsTypeDao;
    /**
     * 查询所有goodsType
     * */
    @Override
    public List<GoodsType> findGoodsTypeAll() {
        return consoleGoodsTypeDao.findGoodsTypeAll();
    }

    /**
     * 添加商品
     * */
    @Override
    public int addGoods(Goods goods) {
        return consoleGoodsTypeDao.addGoods(goods);
    }

    /**
     * 给商品添加对应商品类型
     * */
    @Override
    public int giveGoodsAddGoodsType(GoodsIdAndGoodsType goodsIdAndGoodsType) {
        return consoleGoodsTypeDao.giveGoodsAddGoodsType(goodsIdAndGoodsType);
    }
}

