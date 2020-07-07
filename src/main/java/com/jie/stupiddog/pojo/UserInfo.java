package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private int id;
    private int userId;
    private String name = "stupiddog";
    private Double money;
    private String imagePath = "\\images\\userImages\\moren.jpg";
    private String email = "";
    private Date birthday = new Date();
    private int sex = 1;
    private String phone = "";
    private String individualitySignature = "生活不止眼前的苟且";
    private Date creationtime = new Date();
    private Date modifytime = new Date();

    public UserInfo(int userId) {
        this.userId = userId;
    }
}
