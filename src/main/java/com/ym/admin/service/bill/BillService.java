package com.ym.admin.service.bill;

import com.github.pagehelper.PageInfo;
import com.ym.admin.entity.Bill;
import com.ym.admin.vo.bill.BillListVO;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:08
 * @Desc
 **/
public interface BillService {

    /**
     * 账单列表
     * @param billListVO
     * @return
     */
    PageInfo<Bill> list(BillListVO billListVO);

}
