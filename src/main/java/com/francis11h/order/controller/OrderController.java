package com.francis11h.order.controller;


import com.francis11h.order.converter.OrderForm2orderDTOConverter;
import com.francis11h.order.dto.OrderDTO;
import com.francis11h.order.enums.ResultEnum;
import com.francis11h.order.exception.OrderException;
import com.francis11h.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    /**
     * 1。 参数检验
     * ----------------- service 层做底下的
     * 2。 查询商品信息
     * 3。 计算总价
     * 4。 扣库存(调用商品服务)
     * 5。 订单入库
     */

    @PostMapping("/create")
    public void create(@Valid OrderForm orderForm,
                       BindingResult bindingResult) {   // 表单认证
        if (bindingResult.hasErrors()) {
            log.error("[订单参数不正确]， orderForm = {}", orderForm);
            /**抛出 自定义异常 */
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm --> orderDTO
        OrderDTO orderDTO = OrderForm2orderDTOConverter.convert(orderForm);
    }

}
