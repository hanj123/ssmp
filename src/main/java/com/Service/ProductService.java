package com.Service;

import com.Domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(Integer pageNum,Integer pageSize);

    void save(Product product);
}
