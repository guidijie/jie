package com.jie.stupiddog.vo;

import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.Order;
import lombok.Data;

import java.util.List;

@Data
public class PayVO {

    private String username;
    private String inputPassword;
    private Order order;
    private List<GoodsAndImages> goodsAndImagesList;

}
