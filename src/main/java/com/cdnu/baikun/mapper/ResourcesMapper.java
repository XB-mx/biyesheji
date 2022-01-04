package com.cdnu.baikun.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cdnu.baikun.domain.Resources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.cdnu.baikun.domain.Resources
 */
@Mapper
public interface ResourcesMapper extends BaseMapper<Resources> {
    /**
     * 获取用户点赞量
     * @param resourceId
     * @return
     */
    Integer getResourceLike(Integer resourceId);

    /**
     * 获取浏览量
     * @param resourceId
     * @return
     */
    Integer getResourceView(Integer resourceId);

    List<Resources> listAllByResourcesIds(List<Integer> ids);

}




