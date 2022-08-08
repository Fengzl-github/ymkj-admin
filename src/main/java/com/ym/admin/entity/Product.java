package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:42
 * @Desc 产品
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseIntegerEntity {
    private static final long serialVersionUID = 7284706781127977121L;

    /**
     * 唯一编码
     */
    private String unCode;
    /**
     * 产品名称
     */
    private String prodName;
    /**
     * 库存
     */
    private Integer stock;



    private Integer count;

}
