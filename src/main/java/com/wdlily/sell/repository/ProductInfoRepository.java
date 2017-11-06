package com.wdlily.sell.repository;

import com.wdlily.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品详情
 *
 * @author wangdi
 * @date 2017/10/21 18:24
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    //根据商品状态查询商品详情
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
