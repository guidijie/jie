package com.jie.stupiddog.service.console.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jie.stupiddog.dao.console.ConsoleGoodsAndGoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.console.ConsoleGoodsAndGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 添加商品类型
     * */
    @Override
    public int addGoodsType(GoodsType goodsType){
        return consoleGoodsTypeDao.addGoodsType(goodsType);
    }

    /**
     * 修改商品类型
     * */
    @Override
    public int updateGoodsType(GoodsType goodsType){
        return consoleGoodsTypeDao.updateGoodsType(goodsType);
    }

    /**
     * 查询所有商品
     * */
    @Override
    public Map<String, Object> findGoodsAll(int pageNum){
        Map<String, Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, 20);
        List<GoodsAndImages> goodsAll = consoleGoodsTypeDao.findGoodsAll();
        map.put("goods",goodsAll);
        //封装自定义的page类
        long total = page.getTotal();
        com.jie.stupiddog.utils.Page page1 = new com.jie.stupiddog.utils.Page();
        page1.setTotal(total);
        map.put("page",page1);
        return map;
    }

    /**
     * 根据goodsId更新goods信息
     * */
    @Override
    public int updateGoods(Goods goods){
        return consoleGoodsTypeDao.updateGoods(goods);
    }

    /**
     * 根据goodsId删除goods信息
     * */
    @Override
    public int deleteGoods(int goodsId){
        return consoleGoodsTypeDao.deleteGoods(goodsId);
    }

    /**
     * 根据goodsId删除goods_id_type
     * */
    @Override
    public int deleteGoodsIdType(int goodsId){
        return consoleGoodsTypeDao.deleteGoodsIdType(goodsId);
    }


    /**
     * 批量删除goods_id_type
     * */
    @Override
    public int deleteGoodsList(List<Goods> goodsList){
        return consoleGoodsTypeDao.deleteGoodsList(goodsList);
    }


    /**
     * 根据goodsId删除goods_id_type
     * */
    @Override
    public int deleteGoodsIdTypeList(List<Goods> goodsList){
        return consoleGoodsTypeDao.deleteGoodsIdTypeList(goodsList);
    }


}

