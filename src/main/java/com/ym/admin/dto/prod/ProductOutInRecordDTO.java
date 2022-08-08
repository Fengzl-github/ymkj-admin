package com.ym.admin.dto.prod;

import lombok.Data;

import java.util.Date;

/**
 * @Author Fengzl
 * @Date 2022/7/31 20:50
 * @Desc
 **/
@Data
public class ProductOutInRecordDTO {

    /**
     * 出入库记录id
     */
    private Integer id;
    /**
     * 操作时间
     */
    private Date createTime;
    /**
     * 类型： 1-入库，2-出库
     */
    private Integer type;
    /**
     * 产品id
     */
    private Integer prodId;
    /**
     * 产品名称
     */
    private String prodName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 备注
     */
    private String note;
}
