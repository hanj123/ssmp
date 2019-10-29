package com.Service.impl;

import com.Dao.ImageDao;
import com.Domain.Image;
import com.Service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("imgServiceImpl")
@Transactional
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImageDao imageDao;


    @Override
    public List<Image> findAll() {

        return imageDao.findAll();
    }

    @Override
    public void saveImg(Image image) {

        imageDao.saveImg(image);
    }

    @Override
    public Image findById(String id) {
        return imageDao.findById(id);
    }
}
