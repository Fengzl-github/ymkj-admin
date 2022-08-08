package com.ym.admin.service.login.impl;

import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.login.LoginDTO;
import com.ym.admin.dto.login.UserDTO;
import com.ym.admin.service.login.LoginService;
import com.ym.admin.vo.login.LoginVO;
import org.springframework.stereotype.Service;

/**
 * @Author Fengzl
 * @Date 2022/7/20 9:29
 * @Desc
 **/
@Service
public class LoginServiceImpl implements LoginService {

    private final static String USER_NAME = "8600";
    private final static String PASS_WORD = "1234";

    @Override
    public ResResult<LoginDTO> login(LoginVO loginVO) {

        if (loginVO.getUsername().equals(USER_NAME)
                && loginVO.getPassword().equals(PASS_WORD)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(1);
            userDTO.setMobile("18233521351");
            return ResResult.ok(LoginDTO.builder()
                    .token("ymkjmfzx8600")
                    .agent(userDTO).build());
        } else {
            return ResResult.error("账号或密码错误");
        }

    }
}
