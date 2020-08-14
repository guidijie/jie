package com.jie.stupiddog.controller;

import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.Order;
import com.jie.stupiddog.service.OrderService;
import com.jie.stupiddog.utils.ResponseMessage;
import com.jie.stupiddog.vo.OrderVO;
import com.jie.stupiddog.vo.PayVO;
import com.jie.stupiddog.vo.TimeAndStateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller()
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/pay.html")
    public String toPay() {
        return "/front_desk/pay";
    }

    @GetMapping("/pay-success.html")
    public String toPaySuccess() {
        return "/front_desk/pay-success";
    }

    /**
     * 新建订单
     * */
    @PostMapping("/addOrder")
    @ResponseBody
    public ResponseMessage addCart(@RequestBody List<GoodsAndImages> goodsAndImages, HttpServletRequest servletRequest) {
        Object userNameObj = servletRequest.getSession().getAttribute("uname");
        String userName = "";
        if (userNameObj != null) {
            userName = userNameObj.toString();
            System.out.println(userName);
        }
        Long orderId = orderService.addOrder(goodsAndImages, userName);
        return orderId > 0 ? ResponseMessage.success().addObject("orderId", orderId) :
                ResponseMessage.error().addObject("msg", "订单创建失败");
    }

    /**
     * 查询某一个订单
     * */
    @PostMapping("/selectOrder/{orderId}")
    @ResponseBody
    public ResponseMessage selectOrder(@PathVariable String orderId) {
        Long orderIdNum = Long.valueOf(orderId);
        Order order = orderService.selectOrder(orderIdNum);
        OrderVO orderVO = OrderVO.transToOrderVO(order);
        return orderVO != null ? ResponseMessage.success().addObject("order", orderVO) :
                ResponseMessage.error().addObject("msg", "錯誤");
    }

    /**
    * 查询某一订单的商品
    * */
    @PostMapping("/selectOrderGoods/{orderId}")
    @ResponseBody
    public ResponseMessage selectOrderGoods(@PathVariable String orderId) {
        Long orderIdNum = Long.valueOf(orderId);
        List<GoodsAndImages> goodsAndImages = orderService.selectOrderGoods(orderIdNum);
        return goodsAndImages != null ? ResponseMessage.success().addObject("orderGoodsList", goodsAndImages) :
                ResponseMessage.error().addObject("msg", "錯誤");
    }


    /**
     * 支付
     * */
    @PostMapping("/pay")
    @ResponseBody
    public ResponseMessage pay(@RequestBody PayVO payVO){
        System.out.println(payVO.toString());
        boolean pay = orderService.pay(payVO);
        return pay == true ? ResponseMessage.success().addObject("pay", pay) :
                ResponseMessage.error().addObject("pay", pay);
    }

    /**
     * 取消订单
     * */
    @PostMapping("/cancelOrder")
    @ResponseBody
    public ResponseMessage cancelOrder(@RequestBody Order order){
        boolean cancel = orderService.cancelOrder(order);
        return cancel == true ? ResponseMessage.success().addObject("cancel", cancel) :
                ResponseMessage.error().addObject("cancel", cancel);
    }

    /**
     * 查询订单
     * */
    @PostMapping("/findOrder")
    @ResponseBody
    public ResponseMessage findOrder(@RequestBody TimeAndStateVo timeAndStateVo) {

        List<OrderVO> orderVOList = orderService.findOrder(timeAndStateVo);
        return orderVOList != null ? ResponseMessage.success().addObject("orderGoodsList", orderVOList) :
                ResponseMessage.error().addObject("msg", "錯誤");
    }

    /**
     * 删除订单
     * */
    @GetMapping("/deleteOrder/{id}")
    @ResponseBody
    public ResponseMessage deleteOrder(@PathVariable String id) {
        int order = orderService.deleteOrder(Long.parseLong(id));
        return order > 0 ? ResponseMessage.success().addObject("msg", "删除成功") :
                ResponseMessage.error().addObject("msg", "删除失败");
    }
}
