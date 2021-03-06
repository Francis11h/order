package com.francis11h.order.form;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/** 该包 全部用来表单验证的 验证的是 前台传过来的数据 */

/**
 * 前台传入数据样例
 *
 *      name: "张三"
 *      phone: "18868822111"
 *      address: "3611 Cum Laude"
 *      openid: "ew3euwhd7sjw9diwkq"                //用户的微信openid
 *      items: [{
 *          productId: "1423113435324",
 *          productQuantity: 2                      //购买数量
 *      }]
 */

@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家 微信 openid */
    @NotEmpty(message = "openid必填")
    private String openid;

    /** 购物车不能为空*/
    @NotEmpty(message = "购物车不能为空")
    private String items;
}















