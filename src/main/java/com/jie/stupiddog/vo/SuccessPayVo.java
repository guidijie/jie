package com.jie.stupiddog.vo;

import com.jie.stupiddog.pojo.Order;
import com.jie.stupiddog.pojo.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessPayVo {

    private UserInfo userInfo;
    private Order order;

}
