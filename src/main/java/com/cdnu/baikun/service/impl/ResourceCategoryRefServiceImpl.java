package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.ResourceCategoryRef;
import com.cdnu.baikun.service.ResourceCategoryRefService;
import com.cdnu.baikun.mapper.ResourceCategoryRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ResourceCategoryRefServiceImpl extends ServiceImpl<ResourceCategoryRefMapper, ResourceCategoryRef>
        implements ResourceCategoryRefService {
    @Autowired
    private ResourceCategoryRefMapper refMapper;
    @Override
    public Boolean addResourceCategoryRef(ResourceCategoryRef ref) {
        if (ref==null) return false;
        return save(ref);
    }

    @Override
    public Boolean deleteRefByResourceId(Integer resouceId) {
        if (resouceId==null) return false;
        return removeById(resouceId);
    }

    @Override
    public List<Integer> getCategoryIdListByResourceId(Integer resouceId) {
        if (resouceId==null) return null;

        List<Integer> list = refMapper.getCategoryIdByResourcesId(resouceId);
        return list;

    }

    @Override
    public List<Integer> getResourceIdListByCategoryId(Integer categoryId) {
        if (categoryId==null) return null;

        List<Integer> list = refMapper.listResourcesIdByCategoryId(categoryId);
        return list;
    }
}




