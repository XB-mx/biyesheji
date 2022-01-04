package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Meney;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.enums.UserStatusEnum;
import com.cdnu.baikun.service.MeneyService;
import com.cdnu.baikun.service.UserService;
import com.cdnu.baikun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


/**
 * @author 白坤
 * @data 2021/7/11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MeneyService meneyService;

    @Override
    public User login(String username) {
        User user1 = userMapper.selectByUserName(username);

        Meney money = meneyService.getUserMoney(user1.getUserId());
        user1.setUserMoney(money.getUserNum());


        if (user1 != null) {
            return user1;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer resiger(User user) {
        User user_name = query().eq("user_name", user.getUserName()).one();
        if (user_name==null){
            Integer integer = userMapper.insert(user);
            System.err.println(integer);
            if (integer == 1) {
                //给用户注册积分
                Boolean aBoolean = meneyService.addMoney(user.getUserId());
                return integer;
            }
        }

        return 0;
    }

    @Override
    public Page<User> selectAllList(Integer page,Integer pageSize) {
        Page<User> page1=new Page<>(page,pageSize);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        Page<User> userPage = userMapper.selectPage(page1,queryWrapper);
        if (userPage != null) {
            return userPage;
        }
        return null;
    }

    @Override
    public Page<User> selectList(Integer page,Integer pageSize,Integer status) {
        Page<User> page1=new Page<>(page,pageSize);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(User::getUserStatus,status);

        Page<User> userPage = userMapper.selectPage(page1,queryWrapper);
        if (userPage != null) {
            return userPage;
        }
        return null;
    }

    @Override
    public Boolean disaOrenUser(Integer userId) {
        User user = this.getById(userId);

        if (Objects.equals(user.getUserStatus(),UserStatusEnum.NORMAL.getInteger())){
            user.setUserStatus(UserStatusEnum.DISABLE.getInteger());
        } else if (Objects.equals(user.getUserStatus(),UserStatusEnum.DISABLE.getInteger())){
            user.setUserStatus(UserStatusEnum.NORMAL.getInteger());
        }

        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda()
                .eq(User::getUserId,user.getUserId())
                .set(User::getUserStatus,user.getUserStatus());
        return update(user, updateWrapper);
    }
}




