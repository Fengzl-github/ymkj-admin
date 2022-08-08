package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:09
 * @Desc
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Combo extends BaseIntegerEntity {
    private static final long serialVersionUID = -5864094131930257724L;

    /**
     * 唯一编码
     */
    private String unCode;
    /**
     * 套餐名称
     */
    private String cboName;
    /**
     * 套餐单价
     */
    private BigDecimal price;
    /**
     * 会员价
     */
    private BigDecimal vipPrice;
    /**
     * 套餐使用次数
     */
    private Integer num;

    /**
     * 套餐明细
     */
    private String detail;
}
