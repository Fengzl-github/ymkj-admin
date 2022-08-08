package com.ym.admin.convert;

import com.ym.admin.entity.Project;
import com.ym.admin.vo.pro.ProjectVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * @Author Fengzl
 * @Date 2022/8/5 20:43
 * @Desc
 **/
@Mapper
@Component
public interface ProjectConvert {
    ProjectConvert INSTANCE = Mappers.getMapper(ProjectConvert.class);


    /**
     * ComboVO -> Combo
     * @param projectVO
     * @return
     */
    Project toProject (ProjectVO projectVO);
}
