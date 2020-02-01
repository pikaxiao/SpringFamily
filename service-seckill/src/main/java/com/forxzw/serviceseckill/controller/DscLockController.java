package com.forxzw.serviceseckill.controller;

import com.forxzw.serviceseckill.result.Result;
import com.forxzw.serviceseckill.service.IDscLockService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzw
 */
@RestController
@RequestMapping("/dscLock")
public class DscLockController {

    @Resource
    private IDscLockService dscLockService;

    @PostMapping(value = "/lock")
    public Result lock() {
        dscLockService.lock();
        return new Result();
    }

    @GetMapping(value = "/redissonLock")
    public Result redissonLock() {
        dscLockService.redissonLock();
        return new Result();
    }

    @GetMapping(value = "/redLock")
    public Result redLock() {
        dscLockService.redLock();
        return new Result();
    }
}
