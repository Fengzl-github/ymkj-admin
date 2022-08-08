package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author Fengzl
 * @Date 2022/8/7 17:42
 * @Desc
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CustomerUseComboRecord extends BaseIntegerEntity {
    private static final long serialVersionUID = -2431536944073899935L;

    /**
     * 关联id
     */
    private Integer ccId;
    /**
     * 套餐名称
     */
    private String cboName;


    public CustomerUseComboRecord(CustomerCombo customerCombo) {

        this.ccId = customerCombo.getId();
        this.cboName = customerCombo.getCboName();
    }
}
