package com.ym.admin.dto.csm;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/8/6 14:19
 * @Desc 消费记录
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerGstRecordDTO extends BaseIntegerEntity {
    private static final long serialVersionUID = -6058001152377999048L;

    /**
     * 客户id
     */
    private Integer csmId;
    /**
     * 客户编号
     */
    private String unCode;
    /**
     * 客户姓名
     */
    private String csmName;
    /**
     * 类型:1-充值 2-消费
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
