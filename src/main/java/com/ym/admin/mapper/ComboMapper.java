package com.ym.admin.mapper;

import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Combo;
import com.ym.admin.entity.ComboChangeRecord;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.cbo.ComboListVO;
import com.ym.admin.vo.cbo.ComboVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:17
 * @Desc
 **/
@Repository
public interface ComboMapper {

    /**
     * 查询全部
     * @param comboListVO
     * @return
     */
    List<Combo> findAll(ComboListVO comboListVO);

    /**
     * 新增或修改
     * @param comboVO
     */
    void insertOrUpdate(ComboVO comboVO);


    /**
     * 根据id获取
     * @param id
     * @return
     */
    Combo findById(@Param("id") Integer id);


    /**
     * 修改删除状态
     * @param id
     * @param deleted
     */
    void updateDeleted(@Param("id") Integer id, @Param("deleted") Integer deleted);


    /**
     * 保存记录
     * @param record
     */
    void saveRecord(ComboChangeRecord record);

    /**
     * 变更记录
     * @param recordListVO
     * @return
     */
    List<RecordListDTO> findAllRecord(RecordListVO recordListVO);
}
