package com.wdlily.sell.service.impl;

import com.wdlily.sell.dataobject.ProductInfo;
import com.wdlily.sell.enums.ProductStatusEnum;
import com.wdlily.sell.repository.ProductInfoRepository;
import com.wdlily.sell.service.inter.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangDi
 * @description
 * @date 2017/10/21 21:29
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    /**
    * @description: 查询所有上架商品
    * @author wangdi
    * @date 2017/10/21 21:31
     * 0 已上架 1未上架
    */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
