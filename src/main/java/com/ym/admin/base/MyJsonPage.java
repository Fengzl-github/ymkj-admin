package com.ym.admin.base;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:04
 * @Desc
 **/
@Data
public class MyJsonPage {

    /**
     * 页数
     */
    @NotNull(message = "页数不能为空")
    private Integer page;
    /**
     * 条数
     */
    @NotNull(message = "每页条数不能为空")
    private Integer size;
}
