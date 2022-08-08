package com.ym.admin.mapper;

import com.ym.admin.entity.Bill;
import com.ym.admin.vo.bill.BillListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:17
 * @Desc
 **/
@Repository
public interface BillMapper {

    /**
     * 查询全部
     * @param billListVO
     * @return
     */
    List<Bill> findAll(BillListVO billListVO);

    /**
     * 新增
     * @param bill
     */
    void insert(Bill bill);


}
