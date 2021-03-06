package com.jie.stupiddog.service.impl;

import com.jie.stupiddog.dao.GoodsCartDao;
import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.OrderDao;
import com.jie.stupiddog.dao.UserDao;
import com.jie.stupiddog.pojo.*;
import com.jie.stupiddog.service.OrderService;
import com.jie.stupiddog.vo.OrderVO;
import com.jie.stupiddog.vo.PayVO;
import com.jie.stupiddog.vo.SuccessPayVo;
import com.jie.stupiddog.vo.TimeAndStateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsCartDao goodsCartDao;

    /**
     * 新建订单
     */
    @Override
    public Long addOrder(List<GoodsAndImages> goodsAndImages, String userName) {
        User user = userDao.findByUserName(userName);
        Long id = OrderServiceImpl.orderId();  //订单id
        Double totalMoney = 0.00;  //总金额
        List<OrderGoods> listOrderGoods = new ArrayList<>();  //存放goods id
        for (GoodsAndImages gi : goodsAndImages) {
            OrderGoods orderGoods = new OrderGoods(id, gi.getId());
            listOrderGoods.add(orderGoods);
            totalMoney += gi.getPreferential();
        }

        Order order = new Order(id, user.getId(), "未付款", totalMoney, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        int i = orderDao.addOrder(order);
        if (i > 0) {
            int num = orderDao.addOrderGoods(listOrderGoods);
        }
        return id;
    }

    /**
     * 查询订单
     */
    @Override
    public Order selectOrder(Long orderId) {
        return orderDao.selectOrder(orderId);
    }

    /**
     * 查询订单商品
     */
    @Override
    public List<GoodsAndImages> selectOrderGoods(Long orderId) {
        List<OrderGoods> orderGoods = orderDao.selectOrderGoods(orderId);
        return goodsDao.selectByListGoodsId1(orderGoods);
    }

    /**
     * 查看订单
     * */
    @Override
    public List<OrderVO> findOrder(TimeAndStateVo timeAndStateVo) {
        User user = userDao.findByUserName(timeAndStateVo.getUserName());
        if(user != null){
            timeAndStateVo.setUserId(user.getId());
            List<OrderVO>  OrderVOList = new ArrayList<>();
            List<Order> orderList = orderDao.findOrder(timeAndStateVo);
            if(orderList != null){
                for (Order order : orderList) {
                    OrderVO orderVO = OrderVO.transToOrderVO(order);
                    //查询订单的商品和图片
                    List<OrderGoods> orderGoodsList = orderDao.selectOrderGoods(order.getId());
                    List<GoodsAndImages> goodsAndImagesList = goodsDao.selectByListGoodsId1(orderGoodsList);
                    orderVO.setGoodsAndImagesList(goodsAndImagesList);
                    OrderVOList.add(orderVO);
                }
                return OrderVOList;
            }
        }
        return null;
    }


    /**
     * 支付
     * */
    @Override
    public boolean pay(PayVO payVO) {
        //查询用户
        User user = userDao.findByUserName(payVO.getUsername());
        Order order = new Order();
        order.setUserId(user.getId());
        order.setTotalAmount(payVO.getOrder().getTotalAmount());
        //支付
        int num = userDao.pay(order);
        if(num >0){
            List<UserCourse> userCourseList = new ArrayList<>();
            //支付成功，将商品添加到用户课程里面
            for (GoodsAndImages gi:payVO.getGoodsAndImagesList()) {
                UserCourse userCourse = new UserCourse(user.getId(),gi.getId());
                userCourseList.add(userCourse);
            }
            int i = userDao.addGoodsToCourse(userCourseList);
            if(i>0){
                Order orderStatus = new Order();
                orderStatus.setId(payVO.getOrder().getId());
                orderStatus.setOrderStatus("已完成");
                orderDao.updateOrderStatus(orderStatus);

                //支付成功后删除购物车商品
                for (UserCourse u:userCourseList) {
                    GoodsCart goodsCart = new GoodsCart();
                    goodsCart.setUserId(u.getUserId());
                    goodsCart.setGoodsId(u.getGoodsId());
                    goodsCartDao.deleteCart(goodsCart);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 取消订单
     */
    public boolean cancelOrder(Order order){

        order.setOrderStatus("已取消");
        int i = orderDao.updateOrderStatus(order);
        if(i > 0 ){
            return true;
        }
        return false;
    }

    /**
    * 删除订单
    * */
    @Override
    public int deleteOrder(long id) {
        int i = orderDao.deleteOrder(id);
        if(i>0){
            return orderDao.deleteOrderGoods(id);

        }
        return -1;
    }

    @Override
    public SuccessPayVo successPay(long parseLong) {
        Order order = orderDao.selectOrder(parseLong);
        UserInfo byUserInfo = userDao.findByUserInfo(order.getUserId());
        SuccessPayVo successPayVo= new SuccessPayVo(byUserInfo,order);
        return successPayVo;
    }




    /**
     * 生成orderId
     */
    public static Long orderId() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdfTime.format(new Date()).toString();
        String replace = date.replace("-", "").replace(" ", "").replace(":", "");
        Long id = Long.valueOf(replace);
        return id;
    }


}
