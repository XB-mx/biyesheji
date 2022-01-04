package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.ResourceCategoryRef;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 白坤
 * @Entity com.cdnu.baikun.domain.ResourceCategoryRef
 */
@Mapper
public interface ResourceCategoryRefMapper extends BaseMapper<ResourceCategoryRef> {
    List<Integer> getCategoryIdByResourcesId(Integer resourceId);

    List<Integer> listResourcesIdByCategoryId(Integer categoryId);
}




