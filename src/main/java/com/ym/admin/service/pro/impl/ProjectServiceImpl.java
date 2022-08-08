package com.ym.admin.service.pro.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ym.admin.common.exception.SassException;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.convert.ProjectConvert;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Project;
import com.ym.admin.entity.ProjectChangeRecord;
import com.ym.admin.mapper.ProjectMapper;
import com.ym.admin.service.pro.ProjectService;
import com.ym.admin.util.ClassCompareUtil;
import com.ym.admin.util.UnCodeUtil;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.pro.ProjectListVO;
import com.ym.admin.vo.pro.ProjectVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:09
 * @Desc
 **/
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public PageInfo<Project> list(ProjectListVO projectListVO) {

        PageHelper.startPage(projectListVO.getPageable().getPage(), projectListVO.getPageable().getSize());
        List<Project> list = projectMapper.findAll(projectListVO);

        return new PageInfo<>(list);
    }


    @Override
    public ResResult<Project> saveOrUpdate(ProjectVO projectVO) {
        //如果唯一编码为空,则生成
        if (StringUtils.isEmpty(projectVO.getUnCode())) {
            projectVO.setUnCode(UnCodeUtil.getUncode("PJ"));
        }
        if (Objects.nonNull(projectVO.getId())) {
            Project project = projectMapper.findById(projectVO.getId());
            Optional.ofNullable(project).orElseThrow(() -> new SassException("项目不存在"));
            Project newProject = ProjectConvert.INSTANCE.toProject(projectVO);
            List<Map<String, Object>> maps = ClassCompareUtil.compareFields(project, newProject, new String[]{"proName", "type", "price", "vipPrice", "note"});
            if (!maps.get(0).isEmpty()) {
                ProjectChangeRecord record = new ProjectChangeRecord(project.getId(), maps);
                projectMapper.saveRecord(record);
            }
        }

        projectMapper.insertOrUpdate(projectVO);

        return ResResult.ok();
    }

    @Override
    public ResResult<Project> updateDeleted(Integer id, Integer deleted) {

        projectMapper.updateDeleted(id, deleted);

        return ResResult.ok();
    }

    @Override
    public PageInfo<RecordListDTO> record(RecordListVO recordListVO) {
        PageHelper.startPage(recordListVO.getPageable().getPage(), recordListVO.getPageable().getSize());
        List<RecordListDTO> list = projectMapper.findAllRecord(recordListVO);

        return new PageInfo<>(list);
    }
}
