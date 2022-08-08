package com.ym.admin.vo.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Fengzl
 * @Date 2022/7/19 15:36
 * @Desc
 **/
@Data
public class LoginVO {
    /**
     * 用户
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;
}
