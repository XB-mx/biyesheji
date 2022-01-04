package com.cdnu.baikun.service;

import com.cdnu.baikun.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/26
 */
public interface OrderService extends IService<Order> {
    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    Boolean addOrder(Order order);

    /**
     * 根据订单状态查询订单
     *
     * @param status
     * @return
     */
    List<Order> getOrderByStatus(Integer status);

    /**
     * 查找所有订单
     *
     * @return
     */
    List<Order> getAllOrder();

}
