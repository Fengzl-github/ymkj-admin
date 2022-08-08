package com.ym.admin.vo.cbo;

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
public class ComboListVO {

    /**
     * 名称
     */
    private String cboName;
    /**
     * 分页参数
     */
    @NotNull(message = "分页参数不能为空")
    private @Valid MyJsonPage pageable;
}
