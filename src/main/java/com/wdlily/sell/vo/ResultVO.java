package com.wdlily.sell.vo;

import lombok.Data;

/**
 * @author wangDi
 * @description
 * @date 2017/10/21 22:18
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
