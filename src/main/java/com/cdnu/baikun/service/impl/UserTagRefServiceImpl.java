package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.domain.UserTagRef;
import com.cdnu.baikun.mapper.TagMapper;
import com.cdnu.baikun.service.TagService;
import com.cdnu.baikun.service.UserTagRefService;
import com.cdnu.baikun.mapper.UserTagRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class UserTagRefServiceImpl extends ServiceImpl<UserTagRefMapper, UserTagRef>
        implements UserTagRefService {
    @Autowired
    private UserTagRefMapper userTagRefMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Boolean addUserTagRef(UserTagRef userTagRef) {
        QueryWrapper<UserTagRef> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(UserTagRef::getTagId,userTagRef.getTagId())
                .eq(UserTagRef::getUserId,userTagRef.getUserId());
        UserTagRef one = this.getOne(queryWrapper);
        if (one==null) return this.save(userTagRef);
        return false;
    }

    @Override
    public Boolean deleteUserTagRefByUserId(Integer userId) {
        return this.removeById(userId);
    }

    @Override
    public List<Tag> getUserTag(Integer userId) {
        List<Integer> integers = userTagRefMapper.listTagIdsByUserId(userId);
        List<Tag> tagList = integers.parallelStream()
                .map(tagId -> tagMapper.selectById(tagId))
                .collect(Collectors.toList());
        return tagList;
    }
}




