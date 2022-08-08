package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:41
 * @Desc 客户消费记录
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerPayRecord extends BaseIntegerEntity {
    private static final long serialVersionUID = 4962653322081462771L;
    /**
     * 客户id
     */
    private Integer csmId;
    /**
     * 类型：1-充值，2-消费
     */
    private Integer type;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 备注
     */
    private String note;

}
