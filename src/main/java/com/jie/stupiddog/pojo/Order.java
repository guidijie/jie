package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private int userId;
    private String orderStatus;  //订单状态
    private Double totalAmount;     //总金额
    private Timestamp creationtime;
    private Timestamp modifytime;
}
