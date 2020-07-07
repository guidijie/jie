package com.jie.stupiddog.config;

import com.jie.stupiddog.dao.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.jie.stupiddog.pojo.User byUserName = userDao.findByUserName(username);
        if(byUserName == null){
            throw new UsernameNotFoundException("用户: " + username + " 不存在!");
        }else{
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            User user = new User(byUserName.getUsername(),byUserName.getPassword(),authorities);
            return user;
        }
    }
}
