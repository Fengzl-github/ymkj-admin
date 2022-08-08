package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:41
 * @Desc 账单
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class Bill extends BaseIntegerEntity {
    private static final long serialVersionUID = -7937307046246382250L;

    /**
     * 账单编号
     */
    private String unCode;
    /**
     * 账单类型：1-支出，2-收入
     */
    private Integer type;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 明细
     */
    private String detail;
}
