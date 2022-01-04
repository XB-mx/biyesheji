package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.CommentResourceNewsRef;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.cdnu.baikun.domain.CommentResourceNewsRef
 */
public interface CommentResourceNewsRefMapper extends BaseMapper<CommentResourceNewsRef> {

    /**
     * 根据资源id获取评论id集合
     * @param resourceId
     * @return
     */
    List<Integer> listCommentIdsByResourceId(Integer resourceId);

    /**
     * 根据新闻id获取评论id集合
     * @param newsId
     * @return
     */
    List<Integer> listCommentIdsByNewsId(Integer newsId);
}




