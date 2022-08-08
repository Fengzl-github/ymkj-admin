package com.ym.admin.controller;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.PageResult;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Combo;
import com.ym.admin.service.cbo.ComboService;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.cbo.ComboListVO;
import com.ym.admin.vo.cbo.ComboVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:48
 * @Desc
 **/
@RestController
@RequestMapping("/api/combo")
@RequiredArgsConstructor
public class ComboController {

    private final ComboService comboService;


    /**
     * 套餐列表
     * @param comboListVO
     * @return
     */
    @PostMapping("/list")
    public ResResult<PageResult<Combo>> list(@RequestBody @Valid ComboListVO comboListVO) {

        PageInfo<Combo> page = comboService.list(comboListVO);

        return ResResult.ok(PageResult.<Combo>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }

    /**
     * 新增/修改套餐
     * @param comboVO
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public ResResult<Combo> saveOrUpdate(@RequestBody @Valid ComboVO comboVO) {

        return comboService.saveOrUpdate(comboVO);
    }

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     * @return
     */
    @DeleteMapping("/updateDeleted")
    public ResResult<Combo> updateDeleted(@RequestParam("id") Integer id,
                                            @RequestParam("deleted") Integer deleted){

        return comboService.updateDeleted(id, deleted);
    }



    /**
     * 套餐变更记录列表
     * @param recordListVO
     * @return
     */
    @PostMapping("/record")
    public ResResult<PageResult<RecordListDTO>> record(@RequestBody @Valid RecordListVO recordListVO) {

        PageInfo<RecordListDTO> page = comboService.record(recordListVO);

        return ResResult.ok(PageResult.<RecordListDTO>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }
}
