package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Meney;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.service.MeneyService;
import com.cdnu.baikun.mapper.MeneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author 白坤
 * @date 2021/7/20
 * 继承ServiceImpl类简便开发
 */
@Service
public class MeneyServiceImpl extends ServiceImpl<MeneyMapper, Meney>
        implements MeneyService {
    @Autowired
    private MeneyMapper meneyMapper;
    //条件构造器,注意实例化 实例(meneyQueryWrapper.eq(Meney::getUserId,userId))
    private LambdaQueryWrapper<Meney> meneyQueryWrapper;

    @Override
    public Meney getUserMoney(Integer userId) {
        Meney meney = this.getById(userId);
        if (meney == null) return new Meney();
        return meney;
    }

    @Override
    public Boolean addMoney(Integer userId) {
        Meney meney = new Meney();
        meney.setUserId(userId);
        return save(meney);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean userTrade(User user1, User user2, Integer money) {
        if (money < 0) return false;
        if (user1.getUserMoney() < money) return false;

        user1.setUserMoney(user1.getUserMoney() - money);
        user2.setUserMoney(user2.getUserMoney() + money);

        if (updateUserMoney(user1) && updateUserMoney(user2)) return true;

        return false;
    }

    /**
     * 对用户得金额进行修改
     *
     * @param user
     * @return
     */
    private Boolean updateUserMoney(User user) {
        UpdateWrapper<Meney> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda()
                .eq(Meney::getUserId, user.getUserId())
                .set(Meney::getUserNum, user.getUserMoney());
        return update(updateWrapper);
    }
}




