package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 白坤
 * @date 2021/8/14
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private ImageService imageService;
    @Override
    public Map<String,Object> listCoverVo(Integer page, String keyword) {
        if (keyword==null||"".equals(keyword)) return null;
        Map<String,Object> map=new HashMap<>();
        Page<Resources> resourcesPage = resourcesService.search(page, keyword);
        Page<News> newsPage = newsService.search(page, keyword);
        //获取资源集合和新闻集合
        List<Resources> resources = resourcesPage.getRecords();
        List<News> news = newsPage.getRecords();

        //进行图片获取
        List<Image> resourceImageList = imageService.getImageListByIds(resources);
        List<Image> newsImageList = imageService.getImageListByNewsIds(news);

        //数据封装
        List<CoverVo> resourceCover = coverService.coverVoList(resources, null, resourceImageList);
        List<CoverVo> newsCover = coverService.coverVoList(null, news, newsImageList);

        //合并集合
        Stream<CoverVo> list;
        if (resourceCover==null&&newsCover!=null) list=newsCover.stream();
        else if(resourceCover!=null&&newsCover==null) list=resourceCover.stream();
        else if(resourceCover!=null&&newsCover!=null) list=Stream.concat(resourceCover.stream(),newsCover.stream());
        else list=null;
        //数据页数
        Integer count= Math.toIntExact(resourcesPage.getPages()/5 + newsPage.getPages()/5);
        map.put("count",count);
        map.put("list",list);
        return map;
    }
}
