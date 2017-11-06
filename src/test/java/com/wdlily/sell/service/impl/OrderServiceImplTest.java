package com.wdlily.sell.service.impl;

import com.wdlily.sell.dataobject.OrderDetail;
import com.wdlily.sell.dto.OrderDTO;
import com.wdlily.sell.enums.OrderStatusEnum;
import com.wdlily.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangDi
 * @description
 * @date 2017/10/29 15:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private String BUYYER_OPENID = "12349980";

    private String ORDER_ID = "15092623299742285";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("地球9999");
        orderDTO.setBuyerName("wd");
        orderDTO.setBuyerOpenid(BUYYER_OPENID);
        orderDTO.setBuyerPhone("11111222222");
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderDTO.setPayStatus(PayStatusEnum.WAIT.getCode());

        List<OrderDetail> list = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("2000");
        orderDetail.setProductQuantity(3);
        list.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("3000");
        orderDetail2.setProductQuantity(10);
        list.add(orderDetail2);

        orderDTO.setOrderDetailList(list);
        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("[根据订单ID查询订单：result={}]", orderDTO);
        Assert.assertEquals(orderDTO.getOrderId(), ORDER_ID);
    }

    @Test
    public void findList() throws Exception {
        Pageable pageable = new PageRequest(0, 2);
        Page<OrderDTO> list = orderService.findList(BUYYER_OPENID, pageable);
        Assert.assertNotEquals(0, list.getSize());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.NEW.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.NEW.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

}