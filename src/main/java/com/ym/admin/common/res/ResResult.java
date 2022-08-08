package com.ym.admin.common.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Fengzl
 * @Date 2022/7/18 21:38
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResResult<T> implements Serializable {

    private static final long serialVersionUID = 7511783063917230698L;


    private Integer code;
    private T data;
    private String msg;

    public static <T> ResResult<T> ok() {
        return of(ResCode.OK.getCode(), null, ResCode.OK.getMsg());
    }

    public static <T> ResResult<T> ok(String msg) {
        return of(ResCode.OK.getCode(), null, msg);
    }

    public static <T> ResResult<T> ok(T data) {
        return of(ResCode.OK.getCode(), data, ResCode.OK.getMsg());
    }

    public static <T> ResResult<T> ok(T data, String msg) {
        return of(ResCode.OK.getCode(), data, msg);
    }

    public static <T> ResResult<T> error() {
        return of(ResCode.ERROR.getCode(), null, ResCode.ERROR.getMsg());
    }

    public static <T> ResResult<T> error(String msg) {
        return of(ResCode.ERROR.getCode(), null, msg);
    }

    public static <T> ResResult<T> error(T data) {
        return of(ResCode.ERROR.getCode(), data, ResCode.ERROR.getMsg());
    }

    public static <T> ResResult<T> error(T data, String msg) {
        return of(ResCode.ERROR.getCode(), data, msg);
    }


    public static <T> ResResult<T> of(Integer code, T data, String msg) {
        return new ResResult<>(code, data, msg);
    }


}
