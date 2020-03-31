package com.francis11h.order.service;

import com.francis11h.order.dto.OrderDTO;

public interface OrderService {

    // 由于 create 要用到 两者 orderMaster orderDetail
    // create(orderMaster, orderDetail);
    // 所以 可以用 一个 新的对象 把两者关联起来 然后 方便 其在本project中的使用
    // dto data transfer object 数据传输对象

    OrderDTO create(OrderDTO orderDTO);
}
