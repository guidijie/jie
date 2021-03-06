package com.jie.stupiddog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeAndStateVo {
    private String userName;
    private int userId;
    private String time;
    private String state;
}
