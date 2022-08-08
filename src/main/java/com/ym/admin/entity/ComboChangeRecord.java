package com.ym.admin.entity;

import com.alibaba.fastjson.JSONObject;
import com.ym.admin.base.BaseIntegerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Author Fengzl
 * @Date 2022/7/30 14:38
 * @Desc 项目修改记录
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ComboChangeRecord extends BaseIntegerEntity {
    private static final long serialVersionUID = 1319304035607785924L;

    private static final String STR_MAP_EMPTY = "{}";

    /**
     * 套餐id
     */
    private Integer cboId;
    /**
     * 变更前内容
     */
    private String beforeContent;
    /**
     * 变更后内容
     */
    private String afterContent;


    public ComboChangeRecord(Integer id, List<Map<String, Object>> maps) {
            this.cboId = id;
            this.beforeContent = JSONObject.toJSONString(maps.get(0));
            this.afterContent = JSONObject.toJSONString(maps.get(1));
    }
}
