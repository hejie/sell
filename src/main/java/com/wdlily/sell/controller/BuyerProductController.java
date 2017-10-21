package com.wdlily.sell.controller;

import com.wdlily.sell.dataobject.ProductCategory;
import com.wdlily.sell.dataobject.ProductInfo;
import com.wdlily.sell.service.inter.ProductCategoryService;
import com.wdlily.sell.service.inter.ProductInfoService;
import com.wdlily.sell.utils.ResponseUtil;
import com.wdlily.sell.vo.ProductInfoVO;
import com.wdlily.sell.vo.ProductVO;
import com.wdlily.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangDi
 * @description 处理用户购买产品
 * @date 2017/10/21 22:26
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * @description: 返回所有商品分类列表
     * @author wangdi
     * @date 2017/10/21 23:29
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        // 查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //lambda表达式
        List<Integer> categoryList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryList);

        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResponseUtil.success(productVOList);
    }

}
