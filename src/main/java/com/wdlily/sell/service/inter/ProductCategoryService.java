package com.wdlily.sell.service.inter;

import com.wdlily.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author wangdi
 * @date 2017/10/21 17:08
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);
}
