package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.service.TagService;
import com.cdnu.baikun.mapper.TagMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
        implements TagService {

    @Override
    public Boolean addTag(Tag tag) {
        return this.save(tag);
    }

    @Override
    public Boolean deleteTagByTagId(Integer tagId) {
        return removeById(tagId);
    }

    @Override
    public Boolean updataTag(Tag tag) {
        LambdaUpdateWrapper<Tag> update = new UpdateWrapper<Tag>().lambda();
        update.eq(Tag::getTagId, tag.getTagId());
        update.set(Tag::getTagName, tag.getTagName());

        return update(update);
    }

    @Override
    public Page<Tag> getTagList(Integer page,Integer limit) {

        return page(new Page<>(page,limit));
    }
}




