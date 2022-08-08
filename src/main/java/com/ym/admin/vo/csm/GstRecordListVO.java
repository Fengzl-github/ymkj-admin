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
public class GstRecordListVO {

    /**
     * 客户姓名
     */
    private String csmName;
    /**
     * 分页参数
     */
    @NotNull(message = "分页参数不能为空")
    private @Valid MyJsonPage pageable;
}
