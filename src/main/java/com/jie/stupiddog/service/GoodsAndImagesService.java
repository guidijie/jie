package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.utils.ResponseMessage;
import com.jie.stupiddog.vo.GoodsVo;

import java.util.List;
import java.util.Map;

public interface GoodsAndImagesService {

    //按照goods_id查询
    public GoodsAndImages findAllGoodsId(int id);

//    //按照goodsType查询
//    public Map<String,Object> aa(String goodsType, String level , int pageNum);
//
//    //按照level 查询
//    public Map<String, Object> findLevel(String goodsType, String level , int pageNum);

    //按照GoodsVo类查询
    public Map<String, Object> findIfGoodsVo(GoodsVo goodsVo, int pageNum);

    //搜索
    public Map<String, Object> searchGoods(GoodsVo goodsVo, int pageNum);


}
