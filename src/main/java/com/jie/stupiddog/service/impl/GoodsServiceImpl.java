package com.jie.stupiddog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    public GoodsDao goodsDao;

    @Resource
    public GoodsTypeDao goodsTypeDao;

    @Override
    public Map<String,List<Goods>> findAll() {
        return null;
    }

    @Override
    public  List<Goods>  findById(int goodsId) {
        List<Goods> Goods = goodsDao.findById(goodsId);
        return Goods;
    }


    @Override
    public Map<String, List<GoodsAndImages>> selectByIds() {
        Map<String,List<GoodsAndImages>> map = new HashMap<>();
        //查询所有商品类型
        List<GoodsType> goodsTypeDaoAll = goodsTypeDao.findAll();
        for (GoodsType gt: goodsTypeDaoAll) {
            List<GoodsIdAndGoodsType> byGoodsTypeId = goodsTypeDao.findByGoodsTypeId(gt.getId());
            for (GoodsIdAndGoodsType g : byGoodsTypeId){
                //根据goodsId查询商品
                GoodsAndImages goodsAndImages = goodsDao.findById2(g.getGoodsId());
                //判断map中是否存在key
                if (map.containsKey(gt.getTypeName())){
                    List<GoodsAndImages> list = map.get(gt.getTypeName());
                    list.add(goodsAndImages);
                }else{
                    List<GoodsAndImages> list2 = new ArrayList<>();
                    list2.add(goodsAndImages);
                    map.put(gt.getTypeName(),list2);
                }
            }
        }
        return map;
    }

    @Override
    public List<Goods> selectGrade() {
        return goodsDao.selectGrade();
    }


}
