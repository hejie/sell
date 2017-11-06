package com.wdlily.sell.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.wdlily.sell.dataobject.OrderDetail;
import com.wdlily.sell.dto.OrderDTO;
import com.wdlily.sell.enums.ResultEnum;
import com.wdlily.sell.exception.SellException;
import com.wdlily.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangDi
 * @description
 * @date 2017/11/5 22:57
 */
@Slf4j
public class OrderForm2OrderDTOConverter {


    public static OrderDTO converter(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenId());

        Gson gson = new Gson();
        List<OrderDetail> list = new ArrayList<OrderDetail>();
        try {
            list = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (JsonSyntaxException e) {
            log.error("[对象转换] orderForm.items -> orderDetail错误，String = ", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(list);

        return orderDTO;

    }
}
