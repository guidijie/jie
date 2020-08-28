package com.jie.stupiddog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jie.stupiddog.dao.GoodsAndImagesDao;
import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.service.GoodsAndImagesService;
import com.jie.stupiddog.vo.GoodsVo;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsAndImagesServiceImpl implements GoodsAndImagesService {
    @Resource
    public GoodsAndImagesDao goodsAndImagesDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Override
    public GoodsAndImages findAllGoodsId(int id) {
        return goodsAndImagesDao.findGoodsId(id);
    }

    @Override
    public Map<String, Object> findIfGoodsVo(GoodsVo goodsVo, int pageNum) {
        Map<String, Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, 2);
        List<GoodsAndImages> goodsVo1 = goodsAndImagesDao.findIfGoodsVo(goodsVo);
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
    public Map<String, Object> searchGoods(GoodsVo goodsVo, int pageNum) {
        Map<String, Object> map = new HashMap<>();
        Page<Object> page = PageHelper.startPage(pageNum, 2);
        List<GoodsAndImages> goods = goodsAndImagesDao.searchGoods(goodsVo);
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
}
