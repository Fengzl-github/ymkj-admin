package com.ym.admin.common.exception;

import com.ym.admin.common.res.ResResult;

/**
 * @Author Fengzl
 * @Date 2022/8/7 14:28
 * @Desc
 **/
public class SassException extends RuntimeException{
    private static final long serialVersionUID = 3533063396599784062L;


    private Integer code;

    public SassException(String msg) {
        super(msg);
        this.code = -1;
    }

    public SassException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public SassException(ResResult resResult) {
        super(resResult.getMsg());
        this.code = resResult.getCode();
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
