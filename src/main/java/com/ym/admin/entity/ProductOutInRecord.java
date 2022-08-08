package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:43
 * @Desc 出入库记录
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductOutInRecord extends BaseIntegerEntity {
    private static final long serialVersionUID = 2948165461203661322L;

    /**
     * 类型： 1-入库，2-出库
     */
    private Integer type;
    /**
     * 产品id
     */
    private Integer prodId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 备注
     */
    private String note;
}
