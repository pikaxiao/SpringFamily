package com.forxzw.serviceseckill.bean;

import lombok.Data;

/**
 * 商品
 *
 * @author xzw
 * @date 2019/5/8
 */
@Data
public class Goods {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 商品库存
     */
    private Integer goodsStock;
}
