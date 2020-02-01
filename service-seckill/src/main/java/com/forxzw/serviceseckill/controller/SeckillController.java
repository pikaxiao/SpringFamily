package com.forxzw.serviceseckill.controller;

import com.forxzw.serviceseckill.param.Order;
import com.forxzw.serviceseckill.result.Result;
import com.forxzw.serviceseckill.service.ISeckillService;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 秒杀
 *
 * @author xzw
 * @date 2019/5/8
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Resource
    private ISeckillService iSeckillService;

    /**
     * 秒杀
     *
     * @param order 下单信息
     * @return 下单结果
     */
    @PostMapping(value = "/doSeckill")
    public Result doSeckill(@RequestBody @Valid Order order) {
        return iSeckillService.doSeckill(order);
    }


}
