package com.jie.stupiddog.service.impl;

import com.jie.stupiddog.dao.GoodsTypeDao;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsTypeImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<GoodsType> selectGoodsType() {
        return goodsTypeDao.findAll();
    }
}
