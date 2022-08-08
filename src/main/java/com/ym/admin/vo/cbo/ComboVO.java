package com.ym.admin.vo.cbo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/25 9:29
 * @Desc
 **/
@Data
public class ComboVO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 唯一编码
     */
    private String unCode;
    /**
     * 名称
     */
    @NotBlank(message = "套餐名称不能为空")
    private String cboName;
    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    private BigDecimal price;
    /**
     * 会员价
     */
    @NotNull(message = "会员价不能为空")
    private BigDecimal vipPrice;
    /**
     * 套餐使用次数
     */
    private Integer num;
    /**
     * 明细
     */
    @NotBlank(message = "明细不能为空")
    private String detail;



    private Integer count;
}
