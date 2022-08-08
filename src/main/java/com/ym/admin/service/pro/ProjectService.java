package com.ym.admin.service.pro;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Project;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.pro.ProjectListVO;
import com.ym.admin.vo.pro.ProjectVO;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:08
 * @Desc
 **/
public interface ProjectService {

    /**
     * 项目列表
     * @param projectListVO
     * @return
     */
    PageInfo<Project> list(ProjectListVO projectListVO);

    /**
     * 新增或者修改
     * @param projectVO
     * @return
     */
    ResResult<Project> saveOrUpdate(ProjectVO projectVO);

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     * @return
     */
    ResResult<Project> updateDeleted(Integer id, Integer deleted);

    /**
     * 项目变更记录列表
     * @param recordListVO
     * @return
     */
    PageInfo<RecordListDTO> record(RecordListVO recordListVO);
}
