package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.TagNewsResourceRef;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.cdnu.baikun.domain.TagNewsResourceRef
 */
@Mapper
public interface TagNewsResourceRefMapper extends BaseMapper<TagNewsResourceRef> {
    /**
     * 根据标签id集合获取新闻id集合
     * @param ids
     * @return
     */
    List<Integer> getNewIdsByTagId(List<Integer> ids);

    /**
     * 根据标签id集合获取资源id集合
     * @param ids
     * @return
     */
    List<Integer> getResourceIdsByTagId(List<Integer> ids);
}




