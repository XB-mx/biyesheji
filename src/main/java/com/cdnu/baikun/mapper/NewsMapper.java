package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.cdnu.baikun.domain.News
 */
public interface NewsMapper extends BaseMapper<News> {
    Integer getNewsLikeCount(Integer id);
    Integer getNewsViewCount(Integer id);
}




