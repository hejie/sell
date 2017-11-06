package com.wdlily.sell.enums;

import lombok.Getter;

/**
 * @author wangDi
 * @description 订单状态
 * @date 2017/10/22 10:49
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINALISHED(1, "已完成"),
    CANCLE(2, "已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
