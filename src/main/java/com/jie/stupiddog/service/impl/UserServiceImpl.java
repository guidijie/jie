package com.jie.stupiddog.service.impl;

import com.jie.stupiddog.dao.GoodsDao;
import com.jie.stupiddog.dao.UserDao;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.pojo.UserCourse;
import com.jie.stupiddog.pojo.UserInfo;
import com.jie.stupiddog.service.UserService;
import com.jie.stupiddog.utils.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private GoodsDao goodsDao;

    /**
     * 按账号查询用户
     * */
    @Override
    public  User findByUserName(String username) {
        return  userDao.findByUserName(username);
    }

    /**
    * 添加用户
    */
    @Override
    public int addUser(User user){
        User byUserName = userDao.findByUserName(user.getUsername());
        if (byUserName == null){
            //生成盐
            String uuid = UUID.randomUUID().toString();
            user.setMask(uuid);
            //密码加盐
            String password = MD5.passwordToMD5(user.getPassword());
            password = MD5.passwordToMD5(password + uuid);
            password = MD5.passwordToMD5(password);
            user.setPassword(password);

            int num = userDao.addUser(user);
            UserInfo userInfo = new UserInfo(user.getId());
            userDao.addUserInfo(userInfo);
            return num;
        }
        return -1;
    }


    /**
     * 修改用户信息
     * */
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userDao.updateUserInfo(userInfo);
    }

    /**
     * 查询用户信息
     * */
    @Override
    public UserInfo findByUserInfo(String username) {
        User user = userDao.findByUserName(username);
        return userDao.findByUserInfo(user.getId());
    }

    /**
     * 判断密码是否正确
     */
    @Override
    public boolean isPassword(String username,String inputPassword) {
        User userName = userDao.findByUserName(username);
        String password = MD5.passwordToMD5(inputPassword.toString());
        password = MD5.passwordToMD5(password + userName.getMask());
        password = MD5.passwordToMD5(password);

        if(userName.getPassword().equals(password)){
            return true;
        }
        return false;
    }


    /**
     * 修改密码
     */
    @Override
    public int changePassword(User user) {

        //生成盐
        String uuid = UUID.randomUUID().toString();
        user.setMask(uuid);
        //密码加盐
        String password = MD5.passwordToMD5(user.getPassword());
        password = MD5.passwordToMD5(password + uuid);
        password = MD5.passwordToMD5(password);
        user.setPassword(password);

        user.setModifytime(new Date());
        System.out.println(user);
        return userDao.changePassword(user);
    }

    @Override
    public List<GoodsAndImages> findCourse(int goodsId) {
        List<UserCourse> course = userDao.findCourse(goodsId);
        if (course ==null){
            return null;
        }
        return goodsDao.selectByListGoodsId3(course);
    }

}
