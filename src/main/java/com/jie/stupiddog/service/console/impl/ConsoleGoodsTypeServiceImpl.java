package com.jie.stupiddog.service.console.impl;

import com.jie.stupiddog.dao.console.ConsoleGoodsTypeDao;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.console.ConsoleGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleGoodsTypeServiceImpl implements ConsoleGoodsTypeService {

    @Autowired
    private ConsoleGoodsTypeDao consoleGoodsTypeDao;
    /**
     * 查询所有goodsType
     * */
    @Override
    public List<GoodsType> findGoodsTypeAll() {
        return consoleGoodsTypeDao.findGoodsTypeAll();
    }
}

