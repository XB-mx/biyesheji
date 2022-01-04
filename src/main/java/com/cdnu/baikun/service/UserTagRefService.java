package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Tag;
import com.cdnu.baikun.domain.UserTagRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 用户关联用户的标签
 */
public interface UserTagRefService extends IService<UserTagRef> {
    /**
     * 添加用户的标签
     *
     * @param userTagRef 用户的标签
     * @return
     */
    Boolean addUserTagRef(UserTagRef userTagRef);

    /**
     * 根据用户id删除用户的标签
     *
     * @param userId
     * @return
     */
    Boolean deleteUserTagRefByUserId(Integer userId);

    /**
     * 获取用户标签列表
     *
     * @param userId
     * @return
     */
    List<Tag> getUserTag(Integer userId);
}
