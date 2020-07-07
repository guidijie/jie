package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private Date creationtime;
    private Date modifytime;
    private String mask;

    public User(String username, String password, Date creationtime, Date modifytime) {
        this.username = username;
        this.password = password;
        this.creationtime = creationtime;
        this.modifytime = modifytime;
    }
}
