package com.francis11h.order.controller;


import com.francis11h.order.VO.ResultVO;
import com.francis11h.order.converter.OrderForm2orderDTOConverter;
import com.francis11h.order.dto.OrderDTO;
import com.francis11h.order.enums.ResultEnum;
import com.francis11h.order.exception.OrderException;
import com.francis11h.order.form.OrderForm;
import com.francis11h.order.service.OrderService;
import com.francis11h.order.utils.ResultVOUtil;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1。 参数检验
     * ----------------- service 层做底下的
     * 2。 查询商品信息  (调用商品服务)
     * 3。 计算总价
     * 4。 扣库存  (调用商品服务)
     * 5。 订单入库
     */

    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm,
                           BindingResult bindingResult) {   // 表单认证


        if (bindingResult.hasErrors()) {
            log.error("[订单参数不正确]， orderForm = {}", orderForm);
            /**抛出 自定义异常 */
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm --> orderDTO
        OrderDTO orderDTO = OrderForm2orderDTOConverter.convert(orderForm);

        //此时 orderDTO 里面 还缺少 orderId orderAmount orderStatus payStatus 等信息

        //转换了之后难保购物车是空的 再判断下
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        //这里 生成上面缺少的 信息
        OrderDTO createResult = orderService.create(orderDTO);


        /**要返回的是 这么一个格式 ResultVO<Map<String, String>> */
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

}
