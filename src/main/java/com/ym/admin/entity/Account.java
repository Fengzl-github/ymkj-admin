package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/27 21:23
 * @Desc 账户
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Account extends BaseIntegerEntity {
    private static final long serialVersionUID = 360632564995534868L;
    /**
     * 唯一编码
     */
    private String unCode;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 客户id
     */
    private Integer csmId;


    private Integer count;
}
