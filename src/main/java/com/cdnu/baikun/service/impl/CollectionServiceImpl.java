package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Collection;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.*;
import com.cdnu.baikun.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection>
implements CollectionService{
    @Autowired
    private NewsService newsService;
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private ImageService imageService;
    @Override
    public Boolean addCollection(Collection collection) {
        Collection one;
        if (collection.getNewsId()==null) one=query().eq("user_id", collection.getUserId()).eq("resource_id", collection.getResourceId()).one();
        else one=query().eq("user_id", collection.getUserId()).eq("news_id", collection.getNewsId()).one();
        if (one==null) return this.save(collection);
        return false;
    }

    @Override
    public Map<String, Object> listCollection(Integer page,Integer userId) {
        Map<String,Object> map=new HashMap<>();
        List<Collection> collections = query().eq("user_id", userId).list();

        if (collections.size()<=0) {
            map.put("count",0);
            map.put("list",null);
            return map;
        }
        //获取新闻
        List<Integer> newsIds = collections.stream().map(Collection::getNewsId).collect(Collectors.toList());
        Page<News> newsPage = newsService.collection(page, newsIds);

        //获取资源
        List<Integer> resourceIds = collections.stream().map(Collection::getResourceId).collect(Collectors.toList());
        IPage<Resources> resourcesPage = resourcesService.getResourceListByResourceIds(resourceIds, page, 5);

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
        //数据总数
        Integer count= Math.toIntExact(resourcesPage.getTotal() + newsPage.getTotal());
        Integer pages= Math.toIntExact(resourcesPage.getPages() / 5 + newsPage.getPages() / 5);
        map.put("count",count);
        map.put("pages",pages);
        map.put("list",list);
        return map;
    }

    @Override
    public Boolean getCollection(Collection collection) {
        Collection one = query().eq("user_id", collection.getUserId()).eq("resource_id", collection.getResourceId())
                .eq("news_id", collection.getNewsId()).one();
        if (one!=null) return true;
        return false;
    }
}




