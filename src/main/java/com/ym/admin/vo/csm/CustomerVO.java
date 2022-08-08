package com.ym.admin.vo.csm;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Fengzl
 * @Date 2022/7/25 9:29
 * @Desc
 **/
@Data
public class CustomerVO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 唯一编码
     */
    private String unCode;
    /**
     * 客户姓名
     */
    @NotBlank(message = "客户姓名不能为空")
    private String csmName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户类型
     */
    @NotNull(message = "用户类型不能为空")
    private Integer type;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;



    private Integer count;
}
