package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.ImageService;
import com.cdnu.baikun.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image>
        implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public Boolean addImage(Image image) {
        return save(image);
    }

    @Override
    public Boolean updateImage(Image image) {

        UpdateWrapper<Image> updateWrapper = new UpdateWrapper<Image>();
        updateWrapper.lambda()
                .eq(Image::getImgId, image.getImgId())
                .set(Image::getImgSrc, image.getImgSrc());


        return update(updateWrapper);
    }

    @Override
    public Image getImageByImageId(Integer imageId) {
        return getById(imageId);
    }

    @Override
    public Boolean deleteImageByImageId(Integer imageId) {
        return removeById(imageId);
    }

    @Override
    public List<Image> getImageListByIds(List<Resources> resources) {
        if (resources.size()==0) return null;
        List<Integer> ids = resources.parallelStream().map(Resources::getResourcesId).collect(Collectors.toList());
        List<Image> images = imageMapper.getImageListByIds(ids);
        return images;

    }

    @Override
    public List<Image> getImageListByNewsIds(List<News> news) {
        if (news.size()==0) return null;
        List<Integer> ids = news.stream().map(News::getNewsId).collect(Collectors.toList());
        List<Image> images = imageMapper.listImgByNewsIds(ids);
        return images;
    }

    @Override
    public Image getImageByResourceId(Integer resourceId) {
        QueryWrapper<Image> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Image::getResourceId,resourceId);
        Image image = this.getOne(queryWrapper);
        return image;
    }

    @Override
    public Image getImageBynewsId(Integer newsId) {
        QueryWrapper<Image> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Image::getNewsId,newsId);
        Image image = this.getOne(queryWrapper);
        return image;
    }
}




