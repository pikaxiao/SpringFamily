package com.forxzw.serviceseckill.service.impl;

import com.forxzw.serviceseckill.service.IDscLockService;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xzw
 */
@Service
public class DscLockServiceImpl implements IDscLockService {

    private static final Logger logger = LoggerFactory.getLogger(DscLockServiceImpl.class);

    private static RedissonClient redissonClient1;
    private static RedissonClient redissonClient2;
    private static RedissonClient redissonClient3;
    static{
        Config config1 = new Config();
        config1.useSingleServer().setAddress("redis://192.168.0.128:6379");
        redissonClient1 = Redisson.create(config1);
        Config config2 = new Config();
        config2.useSingleServer().setAddress("redis://192.168.0.128:6378");
        redissonClient2 = Redisson.create(config2);
        Config config3 = new Config();
        config3.useSingleServer().setAddress("redis://192.168.0.128:6377");
        redissonClient3 = Redisson.create(config3);
    }

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void lock() {
        Jedis jedis = jedisPool.getResource();
        //加锁和过期自动释放锁
        while (!"OK".equals(jedis.set("resource_name", "my_random_value", "NX", "PX", 30000))) {
            try {
                //休眠一秒再次尝试获取锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("#####exception=[{}]", e.getMessage());
            }
        }
        //释放锁
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList("resource_name"), Collections.singletonList("my_random_value"));
        logger.info("######### result = [{}]",result);
        if (Long.valueOf(1).equals(result)) {
            //解锁成功
        } else {
            //解锁失败
        }
    }

    @Override
    public void redissonLock() {

        RLock rlock = redissonClient.getLock("resource_name");
        //设置锁超时时间
        rlock.lock(30, TimeUnit.SECONDS);

        //执行到这里证明已经获得锁
        //do something

        //执行完后要释放锁
        rlock.unlock();

    }

    @Override
    public void redLock(){
        RLock lock1 = redissonClient1.getLock("resource_name");
        RLock lock2 = redissonClient2.getLock("resource_name");
        RLock lock3 = redissonClient3.getLock("resource_name");
        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        //------------------------lock---------------------------------
        //① 阻塞
        // 获取锁并在10秒后自动解锁
        redLock.lock(10, TimeUnit.SECONDS);
        //do something
        redLock.unlock();
        //------------------------lock---------------------------------

//        //------------------------tryLock---------------------------------
//        //② 阻塞100s后放弃请求锁
//        // 等待锁的获取时间长达100秒，获取锁并在10秒后自动解锁
//        try {
//            redLock.tryLock(100, 10, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            redLock.unlock();
//        }
//        //------------------------tryLock---------------------------------
    }

}
