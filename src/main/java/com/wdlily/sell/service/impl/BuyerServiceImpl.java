package com.wdlily.sell.service.impl;

import com.wdlily.sell.dto.OrderDTO;
import com.wdlily.sell.enums.ResultEnum;
import com.wdlily.sell.exception.SellException;
import com.wdlily.sell.service.inter.BuyerService;
import com.wdlily.sell.service.inter.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangDi
 * @description
 * @date 2017/11/6 23:33
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equals(openId)){
            log.error("[查询订单] 订单的openId与当前用户openId不一致，openId={}，orderDTO={}", openId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNWE_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            log.error("[取消订单] 当前待取消订单不存在，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderDTO.getBuyerOpenid().equals(openId)){
            log.error("[取消订单] 订单的openId与当前用户openId不一致，openId={}，orderDTO={}", openId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNWE_ERROR);
        }
        return orderService.cancel(orderDTO);
    }
}
