package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.domain.TagNewsResourceRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 用与推荐用户资源
 * @author 白坤
 * @date 2021/7/27
 */
public interface TagNewsResourceRefService extends IService<TagNewsResourceRef> {
    /**
     * 添加标签与资源或者资讯关联
     * @param ref
     * @return
     */
    Boolean addTagNewsResourceRef(TagNewsResourceRef ref);

    /**
     * 根据标签返回news集合
     * @param ref
     * @return
     */
    List<News> listNewsByTag(List<Tag> ref);
}
