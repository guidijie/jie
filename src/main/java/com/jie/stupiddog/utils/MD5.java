package com.jie.stupiddog.utils;


import com.jie.stupiddog.dao.UserDao;
import com.jie.stupiddog.pojo.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MD5 implements PasswordEncoder{

    @Resource
    private UserDao userDao;


    public static String passwordToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }


    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        if(encodedPassword != null){
            User user = userDao.findByPassword(encodedPassword);
            String mask = user.getMask();

            //密码加盐
            String password = MD5.passwordToMD5(rawPassword.toString());
            password = MD5.passwordToMD5(password + mask);
            password = MD5.passwordToMD5(password);
            return  encodedPassword.equals(password);
        }

        return false;

    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}