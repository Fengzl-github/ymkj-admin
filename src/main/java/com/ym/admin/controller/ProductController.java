package com.ym.admin.controller;

import com.github.pagehelper.PageInfo;
import com.ym.admin.common.res.PageResult;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.prod.ProductOutInRecordDTO;
import com.ym.admin.entity.Product;
import com.ym.admin.service.prod.ProductService;
import com.ym.admin.vo.prod.ProductListVO;
import com.ym.admin.vo.prod.ProductOutInListVO;
import com.ym.admin.vo.prod.ProductOutInVO;
import com.ym.admin.vo.prod.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Fengzl
 * @Date 2022/7/23 18:48
 * @Desc
 **/
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    /**
     * 产品列表
     * @param productListVO
     * @return
     */
    @PostMapping("/list")
    public ResResult<PageResult<Product>> list(@RequestBody @Valid ProductListVO productListVO) {

        PageInfo<Product> page = productService.list(productListVO);

        return ResResult.ok(PageResult.<Product>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }

    /**
     * 新增产品(新品入库)
     * @param productVO
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public ResResult<Product> saveOrUpdate(@RequestBody @Valid ProductVO productVO) {

        return productService.saveOrUpdate(productVO);
    }

    /**
     * 产品出入库
     * @param productOutInVO
     * @return
     */
    @PostMapping("/storage/outin")
    public ResResult<Product> storageOutIn(@RequestBody @Valid ProductOutInVO productOutInVO) {

        return productService.storageOutIn(productOutInVO);
    }


    /**
     * 产品出入库记录
     * @param productOutInListVO
     * @return
     */
    @PostMapping("/outInRecodeList")
    public ResResult<PageResult<ProductOutInRecordDTO>> outInRecodeList(@RequestBody @Valid ProductOutInListVO productOutInListVO) {

        PageInfo<ProductOutInRecordDTO> page = productService.outInRecodeList(productOutInListVO);

        return ResResult.ok(PageResult.<ProductOutInRecordDTO>builder()
                .content(page.getList())
                .page(page.getPages())
                .count(page.getTotal()).build());
    }

}
