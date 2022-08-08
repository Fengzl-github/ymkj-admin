package com.ym.admin.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author Fengzl
 * @Date 2022/7/17 18:31
 * @Desc
 **/
@Data
public class BaseIntegerEntity implements Serializable {

    private static final long serialVersionUID = 4750108239539625913L;
    /**
     * 主键id
     */
    protected Integer id;
    /**
     * 创建时间
     */
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    protected Date createTime;
    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updateTime;
    /**
     * 删除标记 0 - 正常; 其它 - 删除
     */
    protected Byte deleted;

}
