package com.ym.admin.vo.pro;

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
public class ProjectVO {
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
    @NotBlank(message = "项目名称不能为空")
    private String proName;
    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private Integer type;
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
     * 备注
     */
    private String note;



    private Integer count;
}
