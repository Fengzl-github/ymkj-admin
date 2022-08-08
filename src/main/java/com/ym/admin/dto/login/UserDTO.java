package com.ym.admin.dto.login;

import lombok.Data;

/**
 * @Author Fengzl
 * @Date 2022/7/19 15:33
 * @Desc
 **/
@Data
public class UserDTO {

    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
}
