package com.francis11h.order.dto;

/** Data Transfer Object 用于在各个层之间传输*/

import com.francis11h.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/** 建立 这个类 主要就是 为了在 order_master 表中直观的看出表示 每个orderId 对应的 orderDetailList*/

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)      //只返回非空的字段   orderDetailList 有时不被查询   但是这个 可以被全局配置 代替   jackson:
//                                                                                                                            default-property-inclusion: non_null
public class OrderDTO {

    /** 订单id  */
    private String orderId;

    /** 买家姓名  */
    private String buyerName;

    /** 买家手机号  */
    private String buyerPhone;

    /** 买家地址  */
    private String buyerAddress;

    /** 买家微信openid  */
    private String buyerOpenid;

    /** 订单总金额  */
    private BigDecimal orderAmount;

    /** 订单状态  默认新订单  */
    private Integer orderStatus;

    /** 支付状态 默认为0 未支付  */
    private Integer payStatus;


    /** 建立 这个类 主要就是 为了表示这个
     *  因为之前 OrderMaster的每个属性要和数据库 order_master 表中一一对应
     *  但是 该表中没有 orderDetailList 这个属性
     *  所以 要新建一个 传输类 就是方便直接找到 一个orderId 对应的 orderDetail 们
     *
     */
    List<OrderDetail> orderDetailList;
}
