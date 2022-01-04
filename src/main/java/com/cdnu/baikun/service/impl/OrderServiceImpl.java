package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Notice;
import com.cdnu.baikun.domain.Order;
import com.cdnu.baikun.service.OrderService;
import com.cdnu.baikun.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Override
    public Boolean addOrder(Order order) {
        if (order == null) return false;
        return save(order);
    }

    @Override
    public List<Order> getOrderByStatus(Integer status) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Order::getOrderStatus, status);

        return list(queryWrapper);
    }

    @Override
    public List<Order> getAllOrder() {
        return list();
    }
}




