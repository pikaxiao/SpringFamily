package com.forxzw.serviceseckill.bean;

import java.util.Date;
import lombok.Data;

/**
 * 秒杀商品
 *
 * @author xzw
 * @date 2019/5/8
 */
@Data
public class SeckillGoods {

    /**
     * 秒杀商品id
     */
    private Long id;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 秒杀价
     */
    private Double seckillPrice;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;

}
