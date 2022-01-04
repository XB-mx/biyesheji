package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 用于对标签和增删改查
 */
public interface TagService extends IService<Tag> {
    /**
     * 添加标签
     *
     * @param tag
     * @return
     */
    Boolean addTag(Tag tag);

    /**
     * 删除标签
     *
     * @param tagId 标签id
     * @return
     */
    Boolean deleteTagByTagId(Integer tagId);

    /**
     * 修改标签
     *
     * @param tag 标签
     * @return
     */
    Boolean updataTag(Tag tag);

    /**
     * 获得所有标签列表
     *
     * @return
     */
    Page<Tag> getTagList(Integer page, Integer limit);
}
