package com.forxzw.serviceseckill.mapper;

import com.forxzw.serviceseckill.bean.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author xzw
 * @date 2019/5/9
 */
@Mapper
public interface SeckillMapper {


    /**
     * 添加订单
     *
     * @param orderInfo 订单信息
     */
    @Insert("insert into sk_order_info(user_id, goods_id, goods_count, goods_price, status, create_date)values("
            + "#{userId}, #{goodsId}, #{goodsCount}, #{goodsPrice}, #{status},#{createDate} )")
    void addOrderInfo(OrderInfo orderInfo);

    /**
     * 减库存
     *
     * @param goodsId 商品ID
     * @return 跟新的行
     */
    @Update("update sk_goods_seckill set stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count>0")
    int reduceStock(long goodsId);

}
