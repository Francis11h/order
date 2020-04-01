package com.francis11h.order.utils;


import com.francis11h.order.VO.ResultVO;

/** 这个 类 是 封装了 把 对象 写入 ResultVO 的几种方法 成功写入 或者 不成功 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
