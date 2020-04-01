package com.francis11h.order.converter;

import com.francis11h.order.dataobject.OrderDetail;
import com.francis11h.order.dto.OrderDTO;
import com.francis11h.order.enums.ResultEnum;
import com.francis11h.order.exception.OrderException;
import com.francis11h.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2orderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        OrderDTO orderDTO = new OrderDTO();
        /**
         * 为什么 不用 BeanUtils.copyProperties(orderForm, orderDTO);
         *  因为 OrderForm 中 名字字段名称为 name , orderDTO 中 名字字段名称为 buyerName
         *  字段名称不一样 不可以直接转换
         */
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        /** 第一个参数是 String 第二个参数是要转换成的 type（class） 我们这里是 要转换成list */
        /** 转换可能会出错 所以try catch下*/

        List<OrderDetail> orderDetailList = new ArrayList<>();

        Gson gson = new Gson();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){
                    }.getType());
            /** 第二个参数是 把 List<OrderDetail> 的类型取出来 通过TypeToken*/
        } catch (Exception e) {
            log.error("【对象转换】错误, string = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}









