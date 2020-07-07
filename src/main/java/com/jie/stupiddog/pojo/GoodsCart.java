package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCart {
    private int id;
    private int goodsId;
    private int userId;
    private int buyCount;  //商品数量
    private Date creationtime;
    private Date modifytime;

    public GoodsCart(int goodsId, int userId, int buyCount, Date creationtime, Date modifytime) {
        this.goodsId = goodsId;
        this.userId = userId;
        this.buyCount = buyCount;
        this.creationtime = creationtime;
        this.modifytime = modifytime;
    }
}
