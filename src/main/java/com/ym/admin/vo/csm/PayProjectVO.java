package com.ym.admin.vo.csm;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/8/6 20:37
 * @Desc
 **/
@Data
public class PayProjectVO {
    /**
     * 客户id
     */
    @NotNull(message = "客户id不能为空")
    private Integer csmId;
    /**
     * 项目id
     */
    @NotNull(message = "项目id不能为空")
    private Integer proId;
    /**
     * 支付方式
     */
    @NotNull(message = "支付方式不能为空")
    private Integer payWay;
    /**
     * 实付金额
     */
    @NotNull(message = "实付金额不能为空")
    private BigDecimal amount;
}
