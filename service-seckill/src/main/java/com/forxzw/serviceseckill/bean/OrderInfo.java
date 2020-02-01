package com.forxzw.serviceseckill.bean;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * 订单信息
 *
 * @author xzw
 * @date 2019/5/8
 */
@Data
@Builder
public class OrderInfo {
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

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 订单状态，0下单，1已支付，2已发货，3已收货，4已退款，5已完成
     */
    private Integer status;

    /**
     * 下单时间
     */
    private Date createDate;

    /**
     * 付款时间
     */
    private Date payDate;
}
