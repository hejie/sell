package com.wdlily.sell.dto;

import lombok.Data;

/**
 * @author wangDi
 * @description 购物车
 * @date 2017/10/22 12:45
 */
@Data
public class CartDTO {
    /** 商品ID. */
    private String productId;

    /** 商品数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
