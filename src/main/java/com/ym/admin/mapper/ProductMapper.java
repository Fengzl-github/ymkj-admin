package com.ym.admin.mapper;

import com.ym.admin.dto.prod.ProductOutInRecordDTO;
import com.ym.admin.entity.Product;
import com.ym.admin.entity.ProductOutInRecord;
import com.ym.admin.vo.prod.ProductListVO;
import com.ym.admin.vo.prod.ProductOutInListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:17
 * @Desc
 **/
@Repository
public interface ProductMapper {

    /**
     * 查询全部
     * @param productListVO
     * @return
     */
    List<Product> findAll(ProductListVO productListVO);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 修改
     * @param product
     * @return
     */
    int update(Product product);
    /**
     * 新增
     * @param product
     * @return
     */
    void insert(Product product);

    /**
     * 保存出入库记录
     * @param productOutInRecord
     */
    void saveRecord(ProductOutInRecord productOutInRecord);

    /**
     * 出入库记录
     * @param productOutInListVO
     * @return
     */
    List<ProductOutInRecordDTO> findOutInRecordList(ProductOutInListVO productOutInListVO);
}
