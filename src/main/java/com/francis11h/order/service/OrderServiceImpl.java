package com.francis11h.order.service;

import com.francis11h.order.dataobject.OrderMaster;
import com.francis11h.order.dto.OrderDTO;
import com.francis11h.order.enums.OrderStatusEnum;
import com.francis11h.order.enums.PayStatusEnum;
import com.francis11h.order.repository.OrderDetailRepository;
import com.francis11h.order.repository.OrderMasterRepository;
import com.francis11h.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //ToDo 查询商品信息
        //ToDo 计算总价
        //ToDo 扣库存(调用商品服务)

        /**订单入库*/
        OrderMaster orderMaster = new OrderMaster();

        // 先给orderDTO 生成 id 再拷贝给 orderMaster
        orderDTO.setOrderId(KeyUtils.genUniqueKey());

        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
