package com.jie.stupiddog.service.console;


import com.jie.stupiddog.pojo.GoodsType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsoleGoodsTypeService {

    /**
     * 查询所有goodsType
     * */
    List<GoodsType> findGoodsTypeAll();
}
