package com.jie.stupiddog.config;

import com.jie.stupiddog.config.authen.MyAuthenticationFailureHandler;
import com.jie.stupiddog.config.authen.MyAuthenticationSuccessHandler;
import com.jie.stupiddog.utils.MD5;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义登录成功处理
    @Resource
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    //自定义登录失败处理
    @Resource
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;


    @Resource
    UserDetailsServiceImpl userDetailsService;



    //定义授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();// 必须有, 不然会 403 forbidden
        http.cors();
        //拦截以下请求
        http.authorizeRequests().
                antMatchers("/cart.html").authenticated();  //任何请求登录后才能访问

        //开启自动配置的登陆功能效果，如果没有登陆，没有权限就会来到登陆页面
        http.formLogin()
                .loginPage("/login.html")  // 登陆页面
                .loginProcessingUrl("/login")   // 登陆表单提交请求
                .passwordParameter("password") //配置 form 表单 密码的 name 属性值
                .usernameParameter("username") //配置 form 表单 用户名的 name 属性值
                .successHandler(myAuthenticationSuccessHandler) //设置登录成功处理
                .failureHandler(myAuthenticationFailureHandler) //设置登录失败处理
                .and()

                //退出登录
                .logout()
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/index.html");
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("jie").password(passwordEncoder().encode("123456")).roles("vip1");

    }

    //自定义加密
    @Bean
    public MD5 passwordEncoder(){
        return new MD5();
    }

    //
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**","/images/**","/swiper/**");

    }
}
