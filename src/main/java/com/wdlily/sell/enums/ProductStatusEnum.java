package com.wdlily.sell.enums;

import lombok.Getter;

/**
 * @author wangDi
 * @description 产品上架状态
 * @date 2017/10/21 21:42
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "已上架"),
    DOWN(1, "已下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
