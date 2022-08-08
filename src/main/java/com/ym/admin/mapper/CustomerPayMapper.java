package com.ym.admin.mapper;

import com.ym.admin.dto.csm.CustomerGstRecordDTO;
import com.ym.admin.entity.CustomerCombo;
import com.ym.admin.entity.CustomerPayRecord;
import com.ym.admin.entity.CustomerProject;
import com.ym.admin.entity.CustomerUseComboRecord;
import com.ym.admin.vo.csm.GstRecordListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/8/6 13:57
 * @Desc
 **/
@Repository
public interface CustomerPayMapper {

    /**
     * 保存消费记录
     * @param payRecord
     */
    void insertPayRecord(CustomerPayRecord payRecord);

    /**
     * 消费记录列表
     * @param gstRecordListVO
     * @return
     */
    List<CustomerGstRecordDTO> findPayRecord(GstRecordListVO gstRecordListVO);

    /**
     * 保存购买套餐
     * @param customerCombo
     */
    void insertCustomerCombo(CustomerCombo customerCombo);

    /**
     * 保存购买项目
     * @param customerProject
     */
    void insertCustomerProject(CustomerProject customerProject);

    /**
     * 获取客户可用的套餐
     * @param csmId
     * @return
     */
    List<CustomerCombo> getCanUseCombo(Integer csmId);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    CustomerCombo findById(Integer id);
    /**
     * 修改客户套餐
     * @param saveDate
     */
    void updateCustomerCombo(CustomerCombo saveDate);

    /**
     * 保存套餐使用记录
     * @param useComboRecord
     */
    void insertUseComboRecord(CustomerUseComboRecord useComboRecord);
    /**
     * 获取套餐使用记录
     * @param ccId
     * @return
     */
    List<CustomerUseComboRecord> getUseComboRecord(Integer ccId);
}
