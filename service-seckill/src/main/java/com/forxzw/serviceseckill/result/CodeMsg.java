package com.forxzw.serviceseckill.result;

import lombok.Data;

/**
 * @author xzw
 * @date 2019/5/9
 */
@Data
public class CodeMsg {

    /**
     * 编码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 成功
     */
    public static CodeMsg SUCCESS = new CodeMsg(200, "成功");

    /**
     * 商品已秒杀完
     */
    public static CodeMsg SECKILL_OVER = new CodeMsg(400001, "商品已秒杀完");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
