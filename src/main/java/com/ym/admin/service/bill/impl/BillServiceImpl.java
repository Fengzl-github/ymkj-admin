package com.ym.admin.service.bill.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ym.admin.entity.Bill;
import com.ym.admin.mapper.BillMapper;
import com.ym.admin.service.bill.BillService;
import com.ym.admin.vo.bill.BillListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:09
 * @Desc
 **/
@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper billMapper;

    @Override
    public PageInfo<Bill> list(BillListVO billListVO) {

        PageHelper.startPage(billListVO.getPageable().getPage(), billListVO.getPageable().getSize());
        List<Bill> list = billMapper.findAll(billListVO);

        return new PageInfo<>(list);
    }



}
