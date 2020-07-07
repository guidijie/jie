package com.jie.stupiddog.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    private Long total ;  //分页总数
    private int pageNum;  //页码
    private int pageSize = 2;  //每页显示多少条数据
}
