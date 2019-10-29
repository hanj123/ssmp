package com.Dao;

import com.Domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {


    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "productId",property = "product",one=@One(select = "com.Dao.ProductDao.findById"))
    })
    @Select("select * from orders")
    List<Orders> findAll();


    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "productId",property = "product",one=@One(select = "com.Dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",one=@One(select = "com.Dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "com.Dao.TravellersDao.findByOrdersId"))
    })
    @Select("select * from orders where id = #{id}")
    Orders findById(Integer id);
}
