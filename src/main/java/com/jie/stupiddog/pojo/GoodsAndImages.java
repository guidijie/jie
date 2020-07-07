package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsAndImages {
    private int id;
    private String name;
    private Double price;
    private Double preferential;
    private String grade;
    private String introduction;
    private String details;
    private String directory;
    private String path;
    private String typeName;
}
