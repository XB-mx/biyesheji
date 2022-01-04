package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.CommentResourceNewsRef;
import com.cdnu.baikun.service.CommentResourceNewsRefService;
import com.cdnu.baikun.mapper.CommentResourceNewsRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CommentResourceNewsRefServiceImpl extends ServiceImpl<CommentResourceNewsRefMapper, CommentResourceNewsRef>
        implements CommentResourceNewsRefService {
    @Autowired
    private CommentResourceNewsRefMapper refMapper;
    @Override
    public List<Integer> listCommentIdsByResourceId(Integer resourceId) {
        if (resourceId==null) return null;
        List<Integer> list = refMapper.listCommentIdsByResourceId(resourceId);
        if (list.size()==0) return null;
        return list;
    }

    @Override
    public List<Integer> listCommentIdsByNewsId(Integer newsId) {
        if (newsId==null) return null;
        List<Integer> list = refMapper.listCommentIdsByNewsId(newsId);
        if (list.size()==0) return null;
        return list;
    }

    @Override
    public Boolean addRef(CommentResourceNewsRef commentResourceNewsRef) {
        return this.save(commentResourceNewsRef);
    }

    @Override
    public Boolean delRef(CommentResourceNewsRef commentResourceNewsRef) {
        return removeById(commentResourceNewsRef.getCommentId());
    }
}




