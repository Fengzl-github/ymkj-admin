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
public class ProjectChangeRecord extends BaseIntegerEntity {
    private static final long serialVersionUID = -186806987366652626L;

    /**
     * 项目id
     */
    private Integer proId;
    /**
     * 变更前内容
     */
    private String beforeContent;
    /**
     * 变更后内容
     */
    private String afterContent;

    public ProjectChangeRecord(Integer id, List<Map<String, Object>> maps) {
        this.proId = id;
        this.beforeContent = JSONObject.toJSONString(maps.get(0));
        this.afterContent = JSONObject.toJSONString(maps.get(1));
    }

}
