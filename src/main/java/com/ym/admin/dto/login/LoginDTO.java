package com.ym.admin.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Fengzl
 * @Date 2022/7/19 15:32
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {

    private String token;

    private UserDTO agent;
}
