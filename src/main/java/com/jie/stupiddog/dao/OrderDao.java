package com.jie.stupiddog.dao;

import com.jie.stupiddog.pojo.Order;
import com.jie.stupiddog.pojo.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    /**
     * 新建订单
     */
    public int addOrder(Order order);

    /**
     * 批量插入订单商品
     * */
    public int addOrderGoods(@Param("ListOrderGoods") List<OrderGoods> ListOrderGoods);

    /**
     * 按照orderID查询订单
     * */
    public Order selectOrder(Long orderId);

    /**
     * 查询所有订单
     * */
    public List<Order> selectOrderAll();

    /**
     * 按照orderID查询订单商品
     * */
    public List<OrderGoods> selectOrderGoods(Long orderId);

    /**
     * 修改订单状态
     * */
    public int updateOrderStatus(Order order);
}
