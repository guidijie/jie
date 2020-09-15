package com.jie.stupiddog.dao.console;

import com.jie.stupiddog.pojo.GoodsType;

import java.util.List;

public interface ConsoleGoodsTypeDao {

    /**
     * 查询所有goodsType
     * */
    List<GoodsType> findGoodsTypeAll();

}
