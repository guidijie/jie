package com.jie.stupiddog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private int id ;
    private int userId ;
    private int goodsId ;

    public Course(int userId, int goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }
}
