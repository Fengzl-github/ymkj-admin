package com.ym.admin.service.csm;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.dto.csm.CustomerAccountDTO;
import com.ym.admin.dto.csm.CustomerGstRecordDTO;
import com.ym.admin.entity.Customer;
import com.ym.admin.entity.CustomerCombo;
import com.ym.admin.entity.CustomerUseComboRecord;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.csm.*;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:08
 * @Desc
 **/
public interface CustomerService {

    /**
     * 项目列表
     * @param customerListVO
     * @return
     */
    PageInfo<CustomerAccountDTO> list(CustomerListVO customerListVO);

    /**
     * 新增或者修改
     * @param customerVO
     * @return
     */
    ResResult<Customer> saveOrUpdate(CustomerVO customerVO);

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     * @return
     */
    ResResult<Customer> updateDeleted(Integer id, Integer deleted);


    /**
     * 充值金额
     * @param params
     * @return
     */
    ResResult<Customer> savePayAmount(PayAmountVO params);

    /**
     * 变更记录
     * @param recordListVO
     * @return
     */
    PageInfo<RecordListDTO> record(RecordListVO recordListVO);

    /**
     * 消费记录
     * @param gstRecordListVO
     * @return
     */
    PageInfo<CustomerGstRecordDTO> payRrecord(GstRecordListVO gstRecordListVO);

    /**
     * 购买套餐
     * @param params
     * @return
     */
    ResResult<Customer> payCombo(PayComboVO params);

    /**
     * 购买项目
     * @param params
     * @return
     */
    ResResult<Customer> payProject(PayProjectVO params);

    /**
     * 当前可用套餐
     * @param csmId
     * @return
     */
    ResResult<List<CustomerCombo>> getCanUseCombo(Integer csmId);

    /**
     * 消减次数
     * @param comboCutVO
     * @return
     */
    ResResult<CustomerCombo> comboCutDown(ComboCutVO comboCutVO);

    /**
     * 套餐使用记录
     * @param ccId
     * @return
     */
    ResResult<List<CustomerUseComboRecord>> getUseComboRecord(Integer ccId);
}
