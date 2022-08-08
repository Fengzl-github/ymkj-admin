package com.ym.admin.entity;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:50
 * @Desc 客户
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends BaseIntegerEntity {

    private static final long serialVersionUID = -4638050332730602509L;

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
}
