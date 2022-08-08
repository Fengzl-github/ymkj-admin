package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:41
 * @Desc 客户购买的项目
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CustomerProject extends BaseIntegerEntity {
    private static final long serialVersionUID = 4962653322081462771L;
    /**
     * 客户id
     */
    private Integer csmId;
    /**
     * 类型：0-正常，1-已完成
     */
    private Integer status;
    /**
     * 项目id
     */
    private Integer proId;
    /**
     * 项目编码
     */
    private String proUnCode;
    /**
     * 项目名称
     */
    private String proName;
    /**
     * 项目明细说明
     */
    private String proNote;
    /**
     * 项目单价
     */
    private BigDecimal proPrice;
    /**
     * 项目会员价
     */
    private BigDecimal proVipPrice;
    /**
     * 实付金额
     */
    private BigDecimal amount;


    public CustomerProject(Customer customer, Project project) {
        this.csmId = customer.getId();
        this.proId = project.getId();
        this.proUnCode = project.getUnCode();
        this.proName = project.getProName();
        this.proNote = project.getNote();
        this.proPrice = project.getPrice();
        this.proVipPrice = project.getVipPrice();
    }
}
