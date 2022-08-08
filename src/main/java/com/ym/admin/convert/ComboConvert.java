package com.ym.admin.convert;

import com.ym.admin.entity.Combo;
import com.ym.admin.vo.cbo.ComboVO;
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
public interface ComboConvert {
    ComboConvert INSTANCE = Mappers.getMapper(ComboConvert.class);


    /**
     * ComboVO -> Combo
     * @param comboVO
     * @return
     */
    Combo toCombo (ComboVO comboVO);
}
