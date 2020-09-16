package com.jie.stupiddog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsIdAndGoodsType {

    private int id;
    private int goodsId;
    private int goodsTypeId;

    public GoodsIdAndGoodsType(int goodsId, int goodsTypeId) {
        this.goodsId = goodsId;
        this.goodsTypeId = goodsTypeId;
    }
}
