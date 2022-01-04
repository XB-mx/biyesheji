package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.domain.TagNewsResourceRef;
import com.cdnu.baikun.service.CoverService;
import com.cdnu.baikun.service.ImageService;
import com.cdnu.baikun.service.NewsService;
import com.cdnu.baikun.service.TagNewsResourceRefService;
import com.cdnu.baikun.mapper.TagNewsResourceRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class TagNewsResourceRefServiceImpl extends ServiceImpl<TagNewsResourceRefMapper, TagNewsResourceRef>
        implements TagNewsResourceRefService {
    @Autowired
    private NewsService newsService;
    @Override
    public Boolean addTagNewsResourceRef(TagNewsResourceRef ref) {
        if (ref==null) return false;
        return save(ref);
    }

    @Override
    public List<News> listNewsByTag(List<Tag> tagList) {
        List<Integer> ids = tagList.stream().map(tag -> tag.getTagId()).collect(Collectors.toList());
        QueryWrapper<TagNewsResourceRef> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .select(TagNewsResourceRef::getNewsId)
                .in(TagNewsResourceRef::getTagId,ids)
                .last("limit 8");
        List<TagNewsResourceRef> list = this.list(queryWrapper);
        if (list.size()==0) return null;
        List<Integer> collect = list.stream().map(TagNewsResourceRef::getNewsId).collect(Collectors.toList());
        List<News> news = newsService.query().in("news_id", collect).list();
        return news;
    }
}




