package com.ym.admin.service.cbo;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Combo;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.cbo.ComboListVO;
import com.ym.admin.vo.cbo.ComboVO;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:08
 * @Desc
 **/
public interface ComboService {

    /**
     * 项目列表
     * @param comboListVO
     * @return
     */
    PageInfo<Combo> list(ComboListVO comboListVO);

    /**
     * 新增或者修改
     * @param comboVO
     * @return
     */
    ResResult<Combo> saveOrUpdate(ComboVO comboVO);

    /**
     * 修改删除状态
     * @param id
     * @param deleted
     * @return
     */
    ResResult<Combo> updateDeleted(Integer id, Integer deleted);

    /**
     * 套餐变更记录列表
     * @param recordListVO
     * @return
     */
    PageInfo<RecordListDTO> record(RecordListVO recordListVO);
}
