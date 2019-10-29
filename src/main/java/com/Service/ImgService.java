package com.Service;

import com.Domain.Image;

import java.util.List;

public interface ImgService {

    List<Image> findAll();

    void saveImg(Image image);

    Image findById(String id);
}
