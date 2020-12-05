package com.jie.stupiddog.config.authen;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//自定义登录成功
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    //在application配置文件中配置登陆的类型是JSON数据响应还是做页面响应
    @Value("${spring.security.logintype}")
    private String loginType;

    private ObjectMapper objectMapper = new ObjectMapper();



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        response.getWriter().write(objectMapper.writeValueAsString(ResponseMessage.success().addObject("uname",authentication.getName())));

        if(loginType.equalsIgnoreCase("JSON")){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResponseMessage.success().addObject("uname",authentication.getName())));

        }else{
            // 会帮我们跳转到上一次请求的页面上
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
