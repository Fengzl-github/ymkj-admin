package com.ym.admin.controller;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.PageResult;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Project;
import com.ym.admin.service.pro.ProjectService;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.pro.ProjectListVO;
import com.ym.admin.vo.pro.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:48
 * @Desc
 **/
@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;


    /**
     * 项目列表
     * @param projectListVO
     * @return
     */
    @PostMapping("/list")
    public ResResult<PageResult<Project>> list(@RequestBody @Valid ProjectListVO projectListVO) {

        PageInfo<Project> page = projectService.list(projectListVO);

        return ResResult.ok(PageResult.<Project>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }

    /**
     * 新增/修改项目
     * @param projectVO
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public ResResult<Project> saveOrUpdate(@RequestBody @Valid ProjectVO projectVO) {

        return projectService.saveOrUpdate(projectVO);
    }

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     * @return
     */
    @DeleteMapping("/updateDeleted")
    public ResResult<Project> updateDeleted(@RequestParam("id") Integer id,
                                            @RequestParam("deleted") Integer deleted){

        return projectService.updateDeleted(id, deleted);
    }


    /**
     * 项目变更记录列表
     * @param recordListVO
     * @return
     */
    @PostMapping("/record")
    public ResResult<PageResult<RecordListDTO>> record(@RequestBody @Valid RecordListVO recordListVO) {

        PageInfo<RecordListDTO> page = projectService.record(recordListVO);

        return ResResult.ok(PageResult.<RecordListDTO>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }

}
