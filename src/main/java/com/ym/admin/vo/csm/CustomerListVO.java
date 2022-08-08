package com.ym.admin.vo.csm;

import com.ym.admin.base.MyJsonPage;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:05
 * @Desc
 **/
@Data
public class CustomerListVO {

    /**
     * 客户姓名
     */
    private String csmName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 分页参数
     */
    @NotNull(message = "分页参数不能为空")
    private @Valid MyJsonPage pageable;
}
