package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 用户service
 *
 * @author 白坤
 * @date 2021/7/11
 */
public interface UserService extends IService<User> {
    /**
     * 用户登录方法
     *
     * @param username
     * @return
     */
    User login(String username);


    /**
     * 用户注册方法
     *
     * @param user
     * @return
     */
    Integer resiger(User user);

    /**
     * 获取所有用户列表
     *
     * @return
     */

    Page<User> selectAllList(Integer page,Integer pageSize);

    /**
     * 获取正常/封禁用户列表
     *
     * @return
     */
    Page<User> selectList(Integer page,Integer pageSize,Integer status);

    /**
     * 启用或封禁用户
     * @param userId
     * @return
     */
    Boolean disaOrenUser(Integer userId);


}
