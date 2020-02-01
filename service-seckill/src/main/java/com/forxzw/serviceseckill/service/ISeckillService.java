package com.forxzw.serviceseckill.service;

import com.forxzw.serviceseckill.param.Order;
import com.forxzw.serviceseckill.result.Result;

/**
 * @author xzw
 * @date 2019/5/9
 */
public interface ISeckillService {

    /**
     * 秒杀
     *
     * @param order 下单信息
     * @return 下单结果
     */
    Result doSeckill(Order order);

}
