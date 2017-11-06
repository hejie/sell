package com.wdlily.sell.service.inter;

import com.wdlily.sell.dataobject.OrderMaster;
import com.wdlily.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author wangDi
 * @description 订单
 * @date 2017/10/22 12:06
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderMaster
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完成订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付
     */
    OrderDTO paid(OrderDTO orderDTO);

}
