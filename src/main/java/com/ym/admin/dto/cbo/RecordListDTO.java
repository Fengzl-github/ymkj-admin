package com.ym.admin.dto.cbo;

import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Fengzl
 * @Date 2022/8/5 22:20
 * @Desc
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class RecordListDTO extends BaseIntegerEntity {
    private static final long serialVersionUID = -631743064848574763L;


    /**
     * 编号
     */
    private String unCode;
    /**
     * 变更前内容
     */
    private String beforeContent;
    /**
     * 变更后内容
     */
    private String afterContent;
}
