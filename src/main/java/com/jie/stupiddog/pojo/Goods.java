package com.jie.stupiddog.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private int id;
    private String name;
    private Double price;
    private Double preferential;
    private String grade;
    private String introduction;
    private String details;
    private String directory;
    private Date creationTime;
    private Date modifyTime;
    private String imagePath;





}
