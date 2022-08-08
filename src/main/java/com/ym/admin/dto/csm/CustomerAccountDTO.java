package com.ym.admin.dto.csm;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Author Fengzl
 * @Date 2022/7/29 21:44
 * @Desc
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerAccountDTO extends BaseIntegerEntity{
    private static final long serialVersionUID = -8647937425537887546L;

    /**
     * 编码
     */
    private String unCode;
    /**
     * 客户姓名
     */
    private String csmName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 客户类型: 1-普通客户,2-vip客户
     */
    private Integer type;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;


    /**
     * 唯一编码
     */
    private String accUnCode;
    /**
     * 余额
     */
    private BigDecimal balance;

}
