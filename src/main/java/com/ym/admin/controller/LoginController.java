package com.ym.admin.controller;

import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.login.LoginDTO;
import com.ym.admin.service.login.LoginService;
import com.ym.admin.vo.login.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Fengzl
 * @Date 2022/7/17 19:31
 * @Desc
 **/
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public ResResult<LoginDTO> login(@RequestBody @Valid LoginVO loginVO) {

        return loginService.login(loginVO);
    }

}
