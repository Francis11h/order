package com.francis11h.order.repository;

import com.francis11h.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    // 方法不需要写 因为 只用 jpa 自带的 save 就完事儿了

}
