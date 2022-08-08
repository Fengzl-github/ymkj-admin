package com.ym.admin.common.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Fengzl
 * @Date 2022/7/18 21:32
 * @Desc
 **/
@Getter
@AllArgsConstructor
public enum  ResCode {
    /**
     * 状态码枚举
     */
    OK(200, "操作成功"),
    ERROR(-1, "请求失败，请稍后重试"),
    PARAM_VERIFY_FAILED(2001,"参数校验异常");

    private Integer code;
    private String msg;


}
