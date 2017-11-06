package com.wdlily.sell.exception;

import com.wdlily.sell.enums.ResultEnum;

/**
 * @author wangDi
 * @description 自定义异常
 * @date 2017/10/22 12:29
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
