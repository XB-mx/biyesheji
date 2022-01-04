package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Comment;
import com.cdnu.baikun.domain.CommentResourceNewsRef;
import com.cdnu.baikun.service.CommentResourceNewsRefService;
import com.cdnu.baikun.service.CommentService;
import com.cdnu.baikun.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {
    @Autowired
    private CommentResourceNewsRefService refService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addComment(Comment comment,Integer resourceId,Integer newsId) {
        boolean save = save(comment);
        //为评论添加关联
        CommentResourceNewsRef ref=new CommentResourceNewsRef();
        ref.setCommentId(comment.getCommentId());
        ref.setNewsId(newsId);
        ref.setResourceId(resourceId);
        Boolean ref1 = refService.addRef(ref);
        return save&&ref1;
    }

    @Override
    public Boolean updateComment(Comment comment) {
        //sql语句开始，更改评论内容和时间
        UpdateWrapper<Comment> updateWrapper = new UpdateWrapper<Comment>();
        updateWrapper.lambda()
                .eq(Comment::getCommentId, comment.getCommentId())
                .set(Comment::getCommentContent, comment.getCommentContent())
                .set(Comment::getCommentTime, new Date());

        return this.update(updateWrapper);
    }

    @Override
    public Boolean deleteCommentByCommentId(Integer commentId) {
        return removeById(commentId);
    }

    @Override
    public Comment getComment(Integer commentId) {
        return this.getById(commentId);
    }

    @Override
    public Page<Comment> getCommentList(Integer status,Integer page,Integer pageSize) {
        QueryWrapper<Comment> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Comment::getCommentStatus,status)
                .orderByDesc(Comment::getCommentTime);
        return page(new Page<>(page,pageSize),queryWrapper);
    }

    @Override
    public Page<Comment> listCommentPageByIds(int status,Integer page,List<Integer> ids) {
        QueryWrapper<Comment> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Comment::getCommentStatus,status)
                .in(Comment::getCommentId,ids);
        Page<Comment> commentPage = page(new Page<>(page, 5), queryWrapper);
        return commentPage;
    }

    @Override
    public Boolean ban(Integer id) {
        Comment comment = this.getById(id);

        switch (comment.getCommentStatus()){
            case 0:
                update().eq("comment_id",id).set("comment_status",1).update();
                return true;
            case 1:
                update().eq("comment_id",id).set("comment_status",0).update();
                return true;
        }
        return false;
    }
}




