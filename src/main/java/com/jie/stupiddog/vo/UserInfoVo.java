package com.jie.stupiddog.vo;


import com.jie.stupiddog.pojo.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {

    private int id;
    private int userId;
    private String name;
    private Double money;
    private String imagePath;
    private String email;
    private String birthday;
    private int sex;
    private String phone;
    private String individualitySignature;
    private Date creationtime ;
    private Date modifytime;


    public UserInfoVo(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.userId = userInfo.getUserId();
        this.name = userInfo.getName();
        this.money = userInfo.getMoney();
        this.imagePath = userInfo.getImagePath();
        this.email = userInfo.getEmail();
        this.birthday = UserInfoVo.time(userInfo.getBirthday()) ;
        this.sex = userInfo.getSex();
        this.phone = userInfo.getPhone();
        this.individualitySignature = userInfo.getIndividualitySignature();
        this.creationtime = userInfo.getCreationtime();
        this.modifytime = userInfo.getModifytime();
    }

    public static String time(Date date){
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        return myFmt.format(date);
    }
}
