package com.yaoyao.shop.server.dao;

import com.yaoyao.shop.server.model.OrderAddressModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderAddressDao {
    int deleteByPrimaryKey(Long id);

    int insert(OrderAddressModel record);

    int insertSelective(OrderAddressModel record);

    OrderAddressModel selectByPrimaryKey(Long id);

    OrderAddressModel selectByOrderId(Long orderId);

    int updateByPrimaryKeySelective(OrderAddressModel record);

    int updateByPrimaryKey(OrderAddressModel record);
}