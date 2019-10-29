package com.Dao;

import com.Domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellersDao {

    @Select("select * from order_traveller inner join traveller on order_traveller.travellerId=traveller.id where orderId=#{orderId}")
    List<Traveller> findByOrdersId(Integer orderId);
}
