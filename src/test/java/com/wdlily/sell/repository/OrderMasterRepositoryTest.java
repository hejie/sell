package com.wdlily.sell.repository;

import com.wdlily.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author wangDi
 * @description
 * @date 2017/10/22 11:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void findByBuyerOpenId() throws Exception {
        String buyerOpenid = "9980";
        PageRequest pageRequest = new PageRequest(0,3);
        Page<OrderMaster> page = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageRequest);
        Assert.assertNotNull(page);
    }

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("wd");
        orderMaster.setBuyerPhone("12345678910");
        orderMaster.setBuyerAddress("sz");
        orderMaster.setBuyerOpenid("9980");
        orderMaster.setOrderAmount(new BigDecimal(19.9));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}