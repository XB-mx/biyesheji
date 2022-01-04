package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Collection;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 用户收藏
 * @author 白坤
 * @date 2021/8/15
 */
public interface CollectionService extends IService<Collection> {
    /**
     * 添加收藏
     * @param collection
     * @return
     */
    Boolean addCollection(Collection collection);

    /**
     * 获取收藏
     * @param page
     * @param userId
     * @return
     */
    Map<String,Object> listCollection(Integer page,Integer userId);

    /**
     * 判断是否收藏
     * @param collection
     * @return
     */
    Boolean getCollection(Collection collection);
}
