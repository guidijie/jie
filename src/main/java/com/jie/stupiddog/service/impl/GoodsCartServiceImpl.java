package com.jie.stupiddog.service.impl;

import com.jie.stupiddog.dao.GoodsAndImagesDao;
import com.jie.stupiddog.dao.GoodsCartDao;
import com.jie.stupiddog.dao.UserDao;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsCart;
import com.jie.stupiddog.pojo.User;
import com.jie.stupiddog.service.GoodsCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsCartServiceImpl implements GoodsCartService {

    @Resource
    private UserDao userDao;

    @Resource
    private GoodsCartDao goodsCartDao;

    @Resource
    private GoodsAndImagesDao goodsAndImagesDao;
    /**
     * 添加商品到购物车
     * */
    @Override
    public int addCart(int gid, int uid) {
        GoodsCart cart = new GoodsCart(gid,uid,1,new Date(),new Date());
        GoodsCart goods = goodsCartDao.findGoods(cart);
        if(goods == null){
            return goodsCartDao.addCart(cart);
        }else if(goods != null){
            return 0;
        }
        return -1;
    }

    /**
     * 查询购物车
     * */
    @Override
    public List<GoodsAndImages> findUserCart(String username) {
        List<GoodsAndImages> goodsAndImagesList = new ArrayList<>();
        //查询用户
        User user = userDao.findByUserName(username);
        //查询用户的购物车
        List<GoodsCart> userCart = goodsCartDao.findUserCart(user.getId());
        System.out.println(userCart.size() == 0);
        if(userCart.size() != 0){
            for (GoodsCart gc :userCart) {
                System.out.println(gc.getGoodsId());
                //根据userCart查询商品
                GoodsAndImages goodsAndImages = goodsAndImagesDao.findByGoodsID(gc.getGoodsId());
                goodsAndImagesList.add(goodsAndImages);
            }
            return goodsAndImagesList;
        }
        return null;
    }

    /**
     * 删除购物车某一项商品
     */
    @Override
    public int deleteCart(int gId){
       return goodsCartDao.deleteCart(gId);
    }
}
