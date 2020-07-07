package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGoods {

    private int id;
    private Long orderId;
    private int goodsId;

    public OrderGoods(Long orderId, int goodsId) {
        this.orderId = orderId;
        this.goodsId = goodsId;
    }
}
