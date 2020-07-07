package com.jie.stupiddog.config.authen;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.jie.stupiddog.utils.ResponseMessage;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    //在application配置文件中配置登陆的类型是JSON数据响应还是做页面响应
    @Value("${spring.security.logintype}")
    private String loginType;
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(ResponseMessage.error().addObject("error","账号或者密码错误，请重新输入")));
//        if (loginType.equalsIgnoreCase("JSON")) {
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(objectMapper.writeValueAsString(ResponseMessage.error().addObject("error","账号或者密码错误，请重新输入")));
//        } else {
//            response.setContentType("text/html;charset=UTF-8");
//            super.onAuthenticationFailure(request, response, exception);
//        }
    }
}