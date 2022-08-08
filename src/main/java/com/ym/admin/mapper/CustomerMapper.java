package com.ym.admin.mapper;

import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.dto.csm.CustomerAccountDTO;
import com.ym.admin.entity.Customer;
import com.ym.admin.entity.CustomerChangeRecord;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.csm.CustomerListVO;
import com.ym.admin.vo.csm.CustomerVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:17
 * @Desc
 **/
@Repository
public interface CustomerMapper {

    /**
     * 查询全部
     * @param customerListVO
     * @return
     */
    List<CustomerAccountDTO> findAll(CustomerListVO customerListVO);

    /**
     * 新增或修改
     * @param customerVO
     */
    void insertOrUpdate(CustomerVO customerVO);

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     */
    void updateDeleted(@Param("id") Integer id, @Param("deleted") Integer deleted);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Customer findById(@Param("id") Integer id);

    /**
     * 保存变更记录
     * @param record
     */
    void saveRecord(CustomerChangeRecord record);

    /**
     * 变更记录
     * @param recordListVO
     * @return
     */
    List<RecordListDTO> findAllRecord(RecordListVO recordListVO);
}
