package com.ym.admin.convert;

import com.ym.admin.entity.Customer;
import com.ym.admin.vo.csm.CustomerVO;
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
public interface CustomerConvert {
    CustomerConvert INSTANCE = Mappers.getMapper(CustomerConvert.class);


    /**
     * ComboVO -> Combo
     * @param customerVO
     * @return
     */
    Customer toCustomer (CustomerVO customerVO);
}
