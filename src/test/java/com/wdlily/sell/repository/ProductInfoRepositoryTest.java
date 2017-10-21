package com.wdlily.sell.repository;

import com.wdlily.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangDi
 * @description
 * @date 2017/10/21 21:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> result = productInfoRepository.findByProductStatus(0);
        Assert.assertEquals(new Integer(0),result.get(0).getProductStatus());
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345689");
        productInfo.setProductName("青椒西红柿");
        productInfo.setProductPrice(new BigDecimal(9.9));
        productInfo.setProductStock(99);
        productInfo.setProductDescription("本店新品，限时抢购");
        productInfo.setProductIcon("wdlily.club");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(1);

        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }


}