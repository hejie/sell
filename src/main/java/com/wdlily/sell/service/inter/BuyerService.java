package com.wdlily.sell.service.inter;

import com.wdlily.sell.dto.OrderDTO;

/**
 * @author wangDi
 * @description
 * @date 2017/11/6 23:32
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openId, String orderId);

    OrderDTO cancelOrder(String openId, String orderId);
}
