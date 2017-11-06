package com.wdlily.sell.enums;

import lombok.Getter;

/**
 * @author wangDi
 * @description 订单支付状态
 * @date 2017/10/22 10:54
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");


    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
