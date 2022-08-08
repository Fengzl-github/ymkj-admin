package com.ym.admin.service.cbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ym.admin.common.exception.SassException;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.convert.ComboConvert;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.entity.Combo;
import com.ym.admin.entity.ComboChangeRecord;
import com.ym.admin.mapper.ComboMapper;
import com.ym.admin.service.cbo.ComboService;
import com.ym.admin.util.ClassCompareUtil;
import com.ym.admin.util.UnCodeUtil;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.cbo.ComboListVO;
import com.ym.admin.vo.cbo.ComboVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class ComboServiceImpl implements ComboService {

    @Resource
    private ComboMapper comboMapper;

    @Override
    public PageInfo<Combo> list(ComboListVO comboListVO) {

        PageHelper.startPage(comboListVO.getPageable().getPage(), comboListVO.getPageable().getSize());
        List<Combo> list = comboMapper.findAll(comboListVO);

        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Combo> saveOrUpdate(ComboVO comboVO) {
        //如果唯一编码为空,则生成
        if (StringUtils.isEmpty(comboVO.getUnCode())) {
            comboVO.setUnCode(UnCodeUtil.getUncode("CB"));
        }
        if (Objects.nonNull(comboVO.getId())) {
            Combo combo = comboMapper.findById(comboVO.getId());
            Optional.ofNullable(combo).orElseThrow(() -> new SassException("套餐不存在"));
            Combo newCombo = ComboConvert.INSTANCE.toCombo(comboVO);
            List<Map<String, Object>> maps = ClassCompareUtil.compareFields(combo, newCombo, new String[]{"cboName", "price", "vipPrice", "num", "detail"});
            if (!maps.get(0).isEmpty()) {
                ComboChangeRecord record = new ComboChangeRecord(combo.getId(), maps);
                comboMapper.saveRecord(record);
            }
        }
        comboMapper.insertOrUpdate(comboVO);

        return ResResult.ok();
    }

    @Override
    public ResResult<Combo> updateDeleted(Integer id, Integer deleted) {

        comboMapper.updateDeleted(id, deleted);

        return ResResult.ok();
    }

    @Override
    public PageInfo<RecordListDTO> record(RecordListVO recordListVO) {

        PageHelper.startPage(recordListVO.getPageable().getPage(), recordListVO.getPageable().getSize());
        List<RecordListDTO> list = comboMapper.findAllRecord(recordListVO);

        return new PageInfo<>(list);
    }
}
