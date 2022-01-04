package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;

import java.util.List;

/**
 * 数据封装
 * @author 白坤
 * @date 2021/8/10
 */
public interface CoverService {
    /**
     * 数据封装
     * @param resources
     * @param news
     * @param images
     * @return
     */
    List<CoverVo> coverVoList(List<Resources> resources, List<News> news , List<Image> images);

    CoverVo cover(Resources resources,News news,Image image);

}
