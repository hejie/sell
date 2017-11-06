package com.wdlily.sell.repository;

import com.wdlily.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangDi
 * @description
 * @date 2017/10/22 11:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> result = orderDetailRepository.findByOrderId("123456");
        Assert.assertNotNull(result.get(0));
    }

}