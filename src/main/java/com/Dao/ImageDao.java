package com.Dao;

import com.Domain.Image;

import java.util.List;

public interface ImageDao {

    List<Image> findAll();

    void saveImg(Image image);

    Image findById(String id);
}
