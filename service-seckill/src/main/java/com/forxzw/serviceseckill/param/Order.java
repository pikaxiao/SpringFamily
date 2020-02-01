package com.forxzw.serviceseckill.param;


import lombok.Data;

/**
 * 订单参数
 *
 * @author xzw
 */
@Data
public class Order {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 秒杀商品id
     */
    private Long goodsId;


}
