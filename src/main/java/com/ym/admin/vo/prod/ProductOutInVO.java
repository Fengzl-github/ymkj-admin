package com.ym.admin.vo.prod;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/25 9:29
 * @Desc
 **/
@Data
public class ProductOutInVO {
    /**
     * 主键
     */
    @NotNull(message = "id不能为空")
    private Integer id;
    /**
     * 类型 1-出库,2-入库
     */
    @NotNull(message = "类型不能为空")
    private Integer type;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer num;
    /**
     * 备注
     */
    private String note;

}
