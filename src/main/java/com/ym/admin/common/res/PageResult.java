package com.ym.admin.common.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/19 15:15
 * @Desc
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1535206576001520768L;
    /**
     * 总数量
     */
    private Long count;
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 当前页结果集
     */
    private List<T> content;
}
