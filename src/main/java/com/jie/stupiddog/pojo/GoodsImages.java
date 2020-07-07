package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsImages {

    private int id;
    private String path;
    private int goodsId;
    private Date creationTime;
    private Date modifyTime;
    private String alt;


}
