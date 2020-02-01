package com.forxzw.serviceseckill.service;

import com.forxzw.serviceseckill.bean.Goods;

/**
 * @author xzw
 * @date 2019/5/9
 */
public interface IGoodsService {

    /**
     * 根据id查询商品详情
     *
     * @param goodsId 商品id
     * @return Goods商品详情
     */
    Goods getGoodsByGoodsId(long goodsId);

}
