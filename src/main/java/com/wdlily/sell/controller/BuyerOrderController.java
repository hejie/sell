package com.wdlily.sell.controller;

import com.wdlily.sell.converter.OrderForm2OrderDTOConverter;
import com.wdlily.sell.dto.OrderDTO;
import com.wdlily.sell.enums.ResultEnum;
import com.wdlily.sell.exception.SellException;
import com.wdlily.sell.form.OrderForm;
import com.wdlily.sell.service.inter.BuyerService;
import com.wdlily.sell.service.inter.OrderService;
import com.wdlily.sell.utils.ResultVOUtil;
import com.wdlily.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * buyer订单
 *
 * @author wangDi
 * @description
 * @date 2017/11/5 22:41
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确，orderForm=", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单] 购物车不能为空, cart=", orderDTO.getOrderDetailList());
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO orderResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openId,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openId)) {
            log.error("[查询订单列表] 缺少参数openId={}", openId);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        Pageable pageable = new PageRequest(page, size);
        Page<OrderDTO> orderList = orderService.findList(openId, pageable);

        return ResultVOUtil.success(orderList.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openId") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openId") String openId,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openId, orderId);
        return ResultVOUtil.success();
    }
}
