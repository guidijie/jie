package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.*;
import com.jie.stupiddog.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface GoodsDao {

    //查询所有商品
    public List<GoodsAndImages> findAll();

    //按照id查寻商品
    public GoodsAndImages findById(int id);

    //goodsvo类条件查询
    public List<GoodsAndImages> findIfGoodsVo(GoodsVo gv);

    //查询购物车商品
    public GoodsAndImages findByGoodsID(int goodsId);

    //按照id查寻商品
    public GoodsAndImages findById2(int id);


    //搜索
    public List<GoodsAndImages> searchGoods(GoodsVo gv);


    //按照名称模糊查询商品
    public List<Goods> findByLike(String name);

    // 批量查詢1
    public List<GoodsAndImages> selectByListGoodsId(@Param("goods") List<GoodsIdAndGoodsType> GoodsIdAndGoodsType);

    // 批量查詢1
    public List<GoodsAndImages> selectByListGoodsId1(@Param("orderGoodsList") List<OrderGoods> orderGoodsList);

    // 批量查詢2
    public List<Goods> selectByListGoodsId2(@Param("orderGoodsList") List<OrderGoods> orderGoodsList);

    // 批量查詢3
    public List<GoodsAndImages> selectByListGoodsId3(@Param("userCourseList") List<UserCourse> userCourse);

    //查询商品的级别
    public List<Goods> selectGrade();


}
