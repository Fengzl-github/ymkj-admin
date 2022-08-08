package com.ym.admin.controller;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.PageResult;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.entity.Bill;
import com.ym.admin.service.bill.BillService;
import com.ym.admin.vo.bill.BillListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:48
 * @Desc
 **/
@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;


    /**
     * 项目列表
     * @param billListVO
     * @return
     */
    @PostMapping("/list")
    public ResResult<PageResult<Bill>> list(@RequestBody @Valid BillListVO billListVO) {

        PageInfo<Bill> page = billService.list(billListVO);

        return ResResult.ok(PageResult.<Bill>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }


}
