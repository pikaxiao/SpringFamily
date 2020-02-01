package com.forxzw.serviceseckill.mapper;

import com.forxzw.serviceseckill.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xzw
 * @date 2019/5/9
 */
@Mapper
public interface GoodsMapper {

    /**
     * 根据id查询商品详情
     *
     * @param goodsId 商品id
     * @return Goods商品详情
     */
    @Select("select * from sk_goods where id = #{goodsId}")
    Goods getGoodsByGoodsId(@Param("goodsId") long goodsId);


}
