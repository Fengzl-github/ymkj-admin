package com.ym.admin.controller;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.PageResult;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.dto.csm.CustomerAccountDTO;
import com.ym.admin.dto.csm.CustomerGstRecordDTO;
import com.ym.admin.entity.Customer;
import com.ym.admin.entity.CustomerCombo;
import com.ym.admin.entity.CustomerUseComboRecord;
import com.ym.admin.service.csm.CustomerService;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.csm.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:48
 * @Desc
 **/
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    /**
     * 客户列表
     * @param customerListVO
     * @return
     */
    @PostMapping("/list")
    public ResResult<PageResult<CustomerAccountDTO>> list(@RequestBody @Valid CustomerListVO customerListVO) {

        PageInfo<CustomerAccountDTO> page = customerService.list(customerListVO);

        return ResResult.ok(PageResult.<CustomerAccountDTO>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }

    /**
     * 新增/修改客户
     * @param customerVO
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public ResResult<Customer> saveOrUpdate(@RequestBody @Valid CustomerVO customerVO) {

        return customerService.saveOrUpdate(customerVO);
    }

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     * @return
     */
    @DeleteMapping("/updateDeleted")
    public ResResult<Customer> updateDeleted(@RequestParam("id") Integer id,
                                             @RequestParam("deleted") Integer deleted) {

        return customerService.updateDeleted(id, deleted);
    }


    /**
     * 充值
     * @param params
     * @return
     */
    @PostMapping("/savePayAmount")
    public ResResult<Customer> savePayAmount(@RequestBody @Valid PayAmountVO params) {

        return customerService.savePayAmount(params);
    }

    /**
     * 套餐变更记录列表
     * @param recordListVO
     * @return
     */
    @PostMapping("/record")
    public ResResult<PageResult<RecordListDTO>> record(@RequestBody @Valid RecordListVO recordListVO) {

        PageInfo<RecordListDTO> page = customerService.record(recordListVO);

        return ResResult.ok(PageResult.<RecordListDTO>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }


    /**
     * 购买套餐
     * @param params
     * @return
     */
    @PostMapping("/payCombo")
    public ResResult<Customer> payCombo(@RequestBody @Valid PayComboVO params) {

        return customerService.payCombo(params);
    }


    /**
     * 购买项目
     * @param params
     * @return
     */
    @PostMapping("/payProject")
    public ResResult<Customer> payProject(@RequestBody @Valid PayProjectVO params) {

        return customerService.payProject(params);
    }

    /**
     * 当前可用套餐
     * @param csmId
     * @return
     */
    @GetMapping("/getCanUseCombo/{csmId}")
    public ResResult<List<CustomerCombo>> getCanUseCombo(@PathVariable("csmId") @NotNull(message = "客户id不能为空") Integer csmId) {

        return customerService.getCanUseCombo(csmId);
    }

    /**
     * 消减次数
     * @param comboCutVO
     * @return
     */
    @PostMapping("/combo/cutDown")
    public ResResult<CustomerCombo> comboCutDown(@RequestBody @Valid ComboCutVO comboCutVO) {

        return customerService.comboCutDown(comboCutVO);
    }


    /**
     * 套餐使用记录
     * @param ccId
     * @return
     */
    @GetMapping("/getUseComboRecord/{ccId}")
    public ResResult<List<CustomerUseComboRecord>> getUseComboRecord(@PathVariable("ccId") @NotNull(message = "参数ccId不能为空") Integer ccId) {

        return customerService.getUseComboRecord(ccId);
    }



    /**
     * 消费记录
     * @param gstRecordListVO
     * @return
     */
    @PostMapping("/pay/record")
    public ResResult<PageResult<CustomerGstRecordDTO>> payRrecord(@RequestBody @Valid GstRecordListVO gstRecordListVO) {

        PageInfo<CustomerGstRecordDTO> page = customerService.payRrecord(gstRecordListVO);

        return ResResult.ok(PageResult.<CustomerGstRecordDTO>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }


}
