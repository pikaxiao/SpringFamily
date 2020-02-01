package com.forxzw.serviceseckill.controller;

import com.forxzw.serviceseckill.bean.Goods;
import com.forxzw.serviceseckill.result.Result;
import com.forxzw.serviceseckill.service.IGoodsService;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzw
 * @date 2019/5/9
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService goodsService;

    /**
     * 根据id查询商品详情
     *
     * @param goodsId 商品id
     * @return Goods商品详情
     */
    @GetMapping(value = "/detail/{goodsId}")
    public Result<Goods> detail(@NotNull @PathVariable("goodsId") long goodsId) {
        Goods goods = goodsService.getGoodsByGoodsId(goodsId);
        return Result.success(goods);
    }
}
