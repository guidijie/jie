package com.jie.stupiddog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType {

    private int id;
    private String typeName;
    private Date creationTime;
    private Date modifyTime;

}
