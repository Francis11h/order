package com.francis11h.order.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {

    // shift + control + i 用插件自动生成 ID
//    private static final long serialVersionUID = -8769245389197303289L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 返回的具体内容 是个范型 */
    private T data;
}
