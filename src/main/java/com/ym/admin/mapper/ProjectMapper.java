package com.ym.admin.mapper;

import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Project;
import com.ym.admin.entity.ProjectChangeRecord;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.pro.ProjectListVO;
import com.ym.admin.vo.pro.ProjectVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:17
 * @Desc
 **/
@Repository
public interface ProjectMapper {

    /**
     * 查询全部
     * @param projectListVO
     * @return
     */
    List<Project> findAll(ProjectListVO projectListVO);

    /**
     * 新增或修改
     * @param projectVO
     */
    void insertOrUpdate(ProjectVO projectVO);

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     */
    void updateDeleted(@Param("id") Integer id, @Param("deleted") Integer deleted);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Project findById(Integer id);

    /**
     * 保存变更记录
     * @param record
     */
    void saveRecord(ProjectChangeRecord record);

    /**
     * 变更记录
     * @param recordListVO
     * @return
     */
    List<RecordListDTO> findAllRecord(RecordListVO recordListVO);
}
