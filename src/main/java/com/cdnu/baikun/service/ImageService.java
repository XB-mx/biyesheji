package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Image;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 对图片的增删改查(资源和资讯的图片 ， 不是头像 ！)
 */
public interface ImageService extends IService<Image> {
    /**
     * 添加图片
     *
     * @param image
     * @return
     */
    Boolean addImage(Image image);

    /**
     * 更改图片
     *
     * @param image
     * @return
     */
    Boolean updateImage(Image image);

    /**
     * 根据图片id获取图片
     *
     * @param imageId
     * @return
     */
    Image getImageByImageId(Integer imageId);

    /**
     * 根据资源集合获取Image集合
     * @param ids
     * @return
     */
    List<Image> getImageListByIds(List<Resources> ids);

    /**
     * 根绝新闻集合获取Image集合
     * @param ids
     * @return
     */
    List<Image> getImageListByNewsIds(List<News> ids);

    /**
     * 根据图片id删除图片
     *
     * @param imageId
     * @return
     */
    Boolean deleteImageByImageId(Integer imageId);

    /**
     * 根据资源id获取图片
     * @param resourceId
     * @return
     */
    Image getImageByResourceId(Integer resourceId);

    /**
     * 根据新闻id获取图片
     * @param newsId
     * @return
     */
    Image getImageBynewsId(Integer newsId);

}
