package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:50
 * @Desc 项目
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Project extends BaseIntegerEntity {

    private static final long serialVersionUID = -4638050332730602509L;

    /**
     * 编码
     */
    private String unCode;
    /**
     * 项目名称
     */
    private String proName;
    /**
     * 备注
     */
    private String note;
    /**
     * 类型: 1-面部护理,2-身体护理
     */
    private Integer type;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 会员价
     */
    private BigDecimal vipPrice;
}
