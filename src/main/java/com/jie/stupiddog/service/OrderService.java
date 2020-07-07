package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.Order;
import com.jie.stupiddog.pojo.OrderGoods;
import com.jie.stupiddog.vo.OrderVO;
import com.jie.stupiddog.vo.PayVO;

import java.util.List;

public interface OrderService {
    /**
     * 新建订单
     * */
    public Long addOrder(List<GoodsAndImages> goodsAndImages,String userName);

    /**
     *按照orderId查询订单
     * */
    public Order selectOrder(Long orderId);

    /**
     *按照orderId查询订单商品
     * */
    public List<GoodsAndImages> selectOrderGoods(Long orderId);

    /**
     * 查询所有的订单
     * */
    public List<OrderVO> selectOrderAll();

    /**
     *支付
     * */
    public boolean pay(PayVO payVO);
}
