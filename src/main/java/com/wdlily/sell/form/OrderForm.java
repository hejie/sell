package com.wdlily.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Order表单验证
 *
 * @author wangDi
 * @description
 * @date 2017/11/5 22:41
 */
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "电话必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * buyer微信openId
     */
    @NotEmpty(message = "openId必有")
    private String openId;

    /**
     * 购物车信息
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;


}
