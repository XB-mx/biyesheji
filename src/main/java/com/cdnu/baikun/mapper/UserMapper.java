package com.cdnu.baikun.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cdnu.baikun.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author 白坤
 * <p>
 * 用户的mapper
 * @Entity com.cdnu.baikun.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 删除用户（慎用）
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 禁用用户
     *
     * @param id
     * @return
     */
    int disableById(Integer id);

    /**
     * 启用用户
     *
     * @param id
     * @return
     */
    int enableById(Integer id);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    int resiger(@Param("user") User user);

    /**
     * 登录
     *
     * @param username 用户名
     * @return
     */
    User selectByUserName(String username);

    /**
     * 获取所有用户列表
     *
     * @return
     */
    List<User> selectAllList();

    /**
     * 获取不同状态用户列表
     *
     * @return
     */
    List<User> selectList(Integer status);
}




