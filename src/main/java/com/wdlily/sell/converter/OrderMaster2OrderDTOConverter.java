package com.wdlily.sell.converter;

import com.wdlily.sell.dataobject.OrderMaster;
import com.wdlily.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 转换器
 *
 * @author wangDi
 * @description
 * @date 2017/11/5 12:58
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> listConverter(List<OrderMaster> list) {
        return list.stream().map(e -> converter(e)).collect(Collectors.toList());
    }

}
