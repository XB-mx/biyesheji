package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.CommentResourceNewsRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 将评论与资源或资讯关联
 */
public interface CommentResourceNewsRefService extends IService<CommentResourceNewsRef> {
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

    /**
     * 添加评论与新闻或资源的关联
     * @param commentResourceNewsRef
     * @return
     */
    Boolean addRef(CommentResourceNewsRef commentResourceNewsRef);

    /**
     * 删除评论与新闻或资源的关联
     * @param commentResourceNewsRef
     * @return
     */
    Boolean delRef(CommentResourceNewsRef commentResourceNewsRef);
}
