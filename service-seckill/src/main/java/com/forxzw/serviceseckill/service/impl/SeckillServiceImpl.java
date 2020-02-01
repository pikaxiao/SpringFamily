package com.forxzw.serviceseckill.service.impl;

import com.forxzw.serviceseckill.bean.OrderInfo;
import com.forxzw.serviceseckill.mapper.SeckillMapper;
import com.forxzw.serviceseckill.param.Order;
import com.forxzw.serviceseckill.result.CodeMsg;
import com.forxzw.serviceseckill.result.Result;
import com.forxzw.serviceseckill.service.ISeckillService;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


/**
 * @author xzw
 */
@Service
public class SeckillServiceImpl implements ISeckillService {

    @Resource
    private SeckillMapper seckillMapper;

    @Override
    @Transactional
    public Result doSeckill(Order order) {
        OrderInfo orderInfo = OrderInfo.builder().id(order.getId()).userId(order.getUserId()).goodsId(order.getGoodsId())
                .goodsCount(1).goodsPrice(0.01).status(0).createDate(new Date()).build();
        seckillMapper.addOrderInfo(orderInfo);
        //依赖于数据库行锁互斥
        int affectedRows = seckillMapper.reduceStock(orderInfo.getGoodsId());
        if (affectedRows == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //通知CDN商品已秒杀完
            return Result.error(CodeMsg.SECKILL_OVER);
        }
        return Result.success();
    }

}
