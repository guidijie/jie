package com.jie.stupiddog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XiaZaiVo {

    private String name;
    private double price;
    private double preferential;
    private String grade;
    private String typeName;
    private String goodsImg;
    private String introduction;
    private String details;
    private String directory;
    private boolean delivery;


}
