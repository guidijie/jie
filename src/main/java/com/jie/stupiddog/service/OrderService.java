package com.jie.stupiddog.service;

import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.Order;
import com.jie.stupiddog.pojo.OrderGoods;
import com.jie.stupiddog.vo.OrderVO;
import com.jie.stupiddog.vo.PayVO;
import com.jie.stupiddog.vo.SuccessPayVo;
import com.jie.stupiddog.vo.TimeAndStateVo;

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
    public List<OrderVO> findOrder(TimeAndStateVo timeAndStateVo);

    /**
     *支付
     * */
    public boolean pay(PayVO payVO);


    /**
     *取消支付
     */
    public boolean cancelOrder(Order order);

    /**
     * 删除订单
     * */
    public int deleteOrder(long id);


    public SuccessPayVo successPay(long parseLong);
}
