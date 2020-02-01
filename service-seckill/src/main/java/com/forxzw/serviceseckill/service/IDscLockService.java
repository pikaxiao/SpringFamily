package com.forxzw.serviceseckill.service;

/**
 * @author xzw
 */
public interface IDscLockService {
    void lock ();
    void redissonLock();
    void redLock();
}
