package com.jie.stupiddog.utils;

import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

    private String code;  //状态码
    private String Message; //状态信息
    private Map<String,Object> data = new HashMap<>();

    //处理成功的方法
    public static ResponseMessage success(){
        ResponseMessage rm = new ResponseMessage();
        rm.setCode("200");
        rm.setMessage("处理成功");
        return rm;
    }

    //处理失败的方法
    public static ResponseMessage error(){
        ResponseMessage rm = new ResponseMessage();
        rm.setCode("400");
        rm.setMessage("处理失败");
        return rm;
    }
    //添加对象方法
    public ResponseMessage addObject(String name , Object obj){
        this.data.put(name, obj);
        return this;
    }
}
