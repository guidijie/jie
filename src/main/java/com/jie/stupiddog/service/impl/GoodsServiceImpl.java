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
import com.jie.stupiddog.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    public GoodsDao goodsDao;

    @Resource
    public GoodsTypeDao goodsTypeDao;

    @Override
    public Map<String, List<GoodsAndImages>> findAll() {
        List<GoodsAndImages> goodsList = goodsDao.findAll();
        return goodsList.stream().collect(Collectors.groupingBy(GoodsAndImages::getTypeName));
    }

    @Override
    public GoodsAndImages findById(int goodsId) {
        return goodsDao.findById(goodsId);
    }

    @Override
    public Map<String, Object> findIfGoodsVo(GoodsVo goodsVo, int pageNum) {
        Map<String, Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, 6);
        List<GoodsAndImages> goodsVo1 = goodsDao.findIfGoodsVo(goodsVo);
        for (GoodsAndImages gi:goodsVo1) {
            gi.setIntroduction(gi.getIntroduction().replace("</br>",""));
        }
        map.put("goodsLevel",goodsVo1);

        //封装自定义的page类
        long total = page.getTotal();
        int pageNum1 = page.getPageNum();
        com.jie.stupiddog.utils.Page page1 = new com.jie.stupiddog.utils.Page();
        page1.setTotal(total);
        page1.setPageNum(pageNum1);
        map.put("page",page1);
        return map;
    }

    @Override
    public Map<String, Object> searchGoods(GoodsVo goodsVo, int pageNum){
        Map<String, Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, 6);
        List<GoodsAndImages> goods = goodsDao.searchGoods(goodsVo);
        map.put("searchGoods",goods);
        //封装自定义的page类
        long total = page.getTotal();
        int pageNum1 = page.getPageNum();
        com.jie.stupiddog.utils.Page page1 = new com.jie.stupiddog.utils.Page();
        page1.setTotal(total);
        page1.setPageNum(pageNum1);
        map.put("page",page1);
        return map;
    }
    @Override
    public List<Goods> selectGrade() {
        return goodsDao.selectGrade();
    }


}
