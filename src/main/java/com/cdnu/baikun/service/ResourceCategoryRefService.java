package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.ResourceCategoryRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/27
 */
public interface ResourceCategoryRefService extends IService<ResourceCategoryRef> {
    /**
     * 添加资源分类关联
     * @param ref
     * @return
     */
    Boolean addResourceCategoryRef(ResourceCategoryRef ref);

    /**
     * 根据资源id删除资源分类关联
     * @param resouceId
     * @return
     */
    Boolean deleteRefByResourceId(Integer resouceId);

    /**
     * 根据资源id获取分类id集合
     * @param resouceId
     * @return
     */
    List<Integer> getCategoryIdListByResourceId(Integer resouceId);

    /**
     * 根据分类id获取资源id的集合
     * @param categoryId
     * @return
     */
    List<Integer> getResourceIdListByCategoryId(Integer categoryId);
}
