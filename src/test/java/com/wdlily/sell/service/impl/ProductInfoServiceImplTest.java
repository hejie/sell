package com.wdlily.sell.service.impl;

import com.wdlily.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangDi
 * @description
 * @date 2017/10/21 21:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo one = productInfoService.findOne("123456");
        Assert.assertNotNull(one);
    }

    @Test
    public void findAll() throws Exception {
        Pageable pageable = new PageRequest(0,2);
        Page<ProductInfo> all = productInfoService.findAll(pageable);
        Assert.assertNotNull(all);
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = productInfoService.findUpAll();
        Assert.assertNotNull(upAll);
    }

    @Test
    public void save() throws Exception {
    }

}