package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 评论增删改查
 */
public interface CommentService extends IService<Comment> {
    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    Boolean addComment(Comment comment,Integer resourceId,Integer newsId);

    /**
     * 更改评论
     *
     * @param comment
     * @return
     */
    Boolean updateComment(Comment comment);

    /**
     * 根据评论id删除评论
     *
     * @param commentId
     * @return
     */
    Boolean deleteCommentByCommentId(Integer commentId);

    /**
     * 根据评论id获取评论
     *
     * @param commentId
     * @return
     */
    Comment getComment(Integer commentId);

    /**
     * 得到所有评论
     *
     * @return
     */
    Page<Comment> getCommentList(Integer status,Integer page,Integer pageSize);

    /**
     * 根据id集合返回评论集合
     * @param ids
     * @return
     */
    Page<Comment> listCommentPageByIds(int status,Integer page, List<Integer> ids);

    /**
     * 根据评论id解封或封禁评论
     * @param id
     * @return
     */
    Boolean ban(Integer id);
}
