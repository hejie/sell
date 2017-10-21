package com.wdlily.sell.service.inter;

import com.wdlily.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wangDi
 * @description 产品信息
 * @date 2017/10/21 21:22
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    //查询所有上架的
    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
