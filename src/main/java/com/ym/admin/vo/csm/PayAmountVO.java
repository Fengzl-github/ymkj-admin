package com.ym.admin.vo.csm;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/29 22:09
 * @Desc
 **/
@Data
public class PayAmountVO {

    @NotNull(message = "id不能为空")
    private Integer id;
    /**
     * 充值金额
     */
    @NotNull(message = "充值金额不能为空")
    @Min(value = 0, message = "充值金额要大于0")
    private BigDecimal payAmount;
}
