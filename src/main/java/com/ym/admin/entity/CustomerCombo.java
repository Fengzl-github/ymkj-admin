package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:41
 * @Desc 客户购买的套餐
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CustomerCombo extends BaseIntegerEntity {
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
     * 套餐id
     */
    private Integer cboId;
    /**
     * 套餐编码
     */
    private String cboUnCode;
    /**
     * 套餐名称
     */
    private String cboName;
    /**
     * 套餐明细说明
     */
    private String cboDetail;
    /**
     * 套餐总次数
     */
    private Integer cboNum;
    /**
     * 剩余次数
     */
    private Integer lastNum;
    /**
     * 套餐单价
     */
    private BigDecimal cboPrice;
    /**
     * 套餐会员价
     */
    private BigDecimal cboVipPrice;
    /**
     * 实付金额
     */
    private BigDecimal amount;
    /**
     * 支付方式
     */
    private Integer payWay;


    public CustomerCombo(Customer customer, Combo combo) {
        this.csmId = customer.getId();
        this.cboId = combo.getId();
        this.cboUnCode = combo.getUnCode();
        this.cboName = combo.getCboName();
        this.cboDetail = combo.getDetail();
        this.cboNum = combo.getNum();
        this.lastNum = combo.getNum();
        this.cboPrice = combo.getPrice();
        this.cboVipPrice = combo.getVipPrice();
    }
}
