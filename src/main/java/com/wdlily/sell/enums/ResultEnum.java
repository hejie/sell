package com.wdlily.sell.enums;

import lombok.Getter;

/**
 * @author wangDi
 * @description
 * @date 2017/10/22 12:30
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数不正确"),

    PRODUCT_NOT_EXIST(1000, "商品不存在"),

    PRODUCT_STOCK_ERROR(1100, "商品库存不足"),

    ORDER_NOT_EXIST(1200, "订单不存在"),

    ORDERDETAIL_NOT_EXIST(1300, "订单详情不存在"),

    ORDER_STATUS_ERROR(1400, "订单状态不正确"),

    ORDER_UPDATE_FAIL(1500, "订单更新失败"),

    ORDER_PAY_STATUS_ERROR(1600, "订单支付状态不正确"),

    CART_EMPTY(1700, "购物车为空"),

    ORDER_OWNWE_ERROR(1800, "该订单不属于当前用户"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
