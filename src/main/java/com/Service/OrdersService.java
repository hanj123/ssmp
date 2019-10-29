package com.Service;

import com.Domain.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(Integer pageNum,Integer pageSize);

    Orders findById(Integer id);
}
