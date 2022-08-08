package com.ym.admin.service.login;

import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.login.LoginDTO;
import com.ym.admin.vo.login.LoginVO;

/**
 * @Author Fengzl
 * @Date 2022/7/20 9:29
 * @Desc
 **/
public interface LoginService {

    /**
     * 登录
     * @param loginVO
     * @return
     */
    ResResult<LoginDTO> login(LoginVO loginVO);
}
