package com.jie.stupiddog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    private int id;
    private int userId;
    private int roleId;

    public UserRole(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
