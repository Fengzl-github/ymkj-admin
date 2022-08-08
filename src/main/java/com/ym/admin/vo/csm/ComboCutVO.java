package com.ym.admin.vo.csm;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Fengzl
 * @Date 2022/8/6 21:46
 * @Desc
 **/
@Data
public class ComboCutVO {
    /**
     * 客户套餐id
     */
    @NotNull(message = "参数id不能为空")
    private Integer id;
    /**
     * 消减数量
     */
    @NotNull(message = "消减数量不能为空")
    private Integer num;
}
