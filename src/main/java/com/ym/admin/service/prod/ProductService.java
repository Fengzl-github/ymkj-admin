package com.ym.admin.service.prod;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.prod.ProductOutInRecordDTO;
import com.ym.admin.entity.Product;
import com.ym.admin.vo.prod.ProductListVO;
import com.ym.admin.vo.prod.ProductOutInListVO;
import com.ym.admin.vo.prod.ProductOutInVO;
import com.ym.admin.vo.prod.ProductVO;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:08
 * @Desc
 **/
public interface ProductService {

    /**
     * 项目列表
     * @param productListVO
     * @return
     */
    PageInfo<Product> list(ProductListVO productListVO);

    /**
     * 新增或者修改
     * @param productVO
     * @return
     */
    ResResult<Product> saveOrUpdate(ProductVO productVO);

    /**
     * 产品出入库
     * @param productOutInVO
     * @return
     */
    ResResult<Product> storageOutIn(ProductOutInVO productOutInVO);

    /**
     * 产品出入库记录
     * @param productOutInListVO
     * @return
     */
    PageInfo<ProductOutInRecordDTO> outInRecodeList(ProductOutInListVO productOutInListVO);
}
