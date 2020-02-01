package com.forxzw.serviceseckill.service.impl;

import com.forxzw.serviceseckill.bean.Goods;
import com.forxzw.serviceseckill.mapper.GoodsMapper;
import com.forxzw.serviceseckill.service.IGoodsService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author xzw
 * @date 2019/5/9
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 根据id查询商品详情
     *
     * @param goodsId 商品id
     * @return Goods商品详情
     */
    @Override
    public Goods getGoodsByGoodsId(long goodsId) {
        return goodsMapper.getGoodsByGoodsId(goodsId);
    }

}
