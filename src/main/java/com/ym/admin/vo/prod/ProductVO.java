package com.ym.admin.vo.prod;

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
public class ProductVO {
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
    @NotBlank(message = "产品名称不能为空")
    private String prodName;
    /**
     * 单价
     */
    @NotNull(message = "金额不能为空")
    private BigDecimal amount;
    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer num;



    private Integer count;
}
