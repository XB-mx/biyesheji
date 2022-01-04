package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cdnu.baikun.domain.Meney;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdnu.baikun.domain.User;

import java.io.Serializable;

/**
 *
 */
public interface MeneyService extends IService<Meney> {
    /**
     * 得到用户关联得积分表
     *
     * @param userId
     * @return
     */
    Meney getUserMoney(Integer userId);

    /**
     * 注册用户积分
     *
     * @param userId
     * @return
     */
    Boolean addMoney(Integer userId);

    /**
     * 用户得积分交易
     *
     * @param user1 支付方
     * @param user2 收款方
     * @param money 金额
     * @return
     */
    Boolean userTrade(User user1, User user2, Integer money);
}
