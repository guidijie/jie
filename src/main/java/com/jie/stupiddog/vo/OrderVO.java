package com.jie.stupiddog.vo;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderVO {

    private Long id;
    private int userId;
    private String orderStatus;     //订单状态
    private Double totalAmount;     //总金额
    private String createTime;
    private String modifyTime;
    private List<GoodsAndImages> goodsAndImagesList = new ArrayList<>();

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

    public static OrderVO transToOrderVO(Order order) {
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderStatus(order.getOrderStatus());
        orderVO.setCreateTime(dateFormat.format(order.getCreationtime()));
        orderVO.setId(order.getId());
        orderVO.setModifyTime(dateFormat.format(order.getModifytime()));
        orderVO.setTotalAmount(order.getTotalAmount());
        orderVO.setUserId(order.getUserId());
        return orderVO;
    }
}
