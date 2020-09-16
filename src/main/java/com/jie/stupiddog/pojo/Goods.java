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
    private Date creationtime;
    private Date modifytime;
    private String imagePath;


    public Goods(String name, Double price,
                 Double preferential,
                 String grade, String introduction,
                 String details, String directory, Date creationtime,
                 Date modifytime, String imagePath) {
        this.name = name;
        this.price = price;
        this.preferential = preferential;
        this.grade = grade;
        this.introduction = introduction;
        this.details = details;
        this.directory = directory;
        this.creationtime = creationtime;
        this.modifytime = modifytime;
        this.imagePath = imagePath;
    }
}
