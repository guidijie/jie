package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourse {

    private int id;
    private int userId;
    private int goodsId;

    public UserCourse(int userId, int goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }
}
