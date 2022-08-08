package com.ym.admin.service.prod.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ym.admin.common.exception.SassException;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.dto.prod.ProductOutInRecordDTO;
import com.ym.admin.entity.Bill;
import com.ym.admin.entity.Product;
import com.ym.admin.entity.ProductOutInRecord;
import com.ym.admin.mapper.BillMapper;
import com.ym.admin.mapper.ProductMapper;
import com.ym.admin.service.prod.ProductService;
import com.ym.admin.util.UnCodeUtil;
import com.ym.admin.vo.prod.ProductListVO;
import com.ym.admin.vo.prod.ProductOutInListVO;
import com.ym.admin.vo.prod.ProductOutInVO;
import com.ym.admin.vo.prod.ProductVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:09
 * @Desc
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private BillMapper billMapper;

    @Override
    public PageInfo<Product> list(ProductListVO productListVO) {

        PageHelper.startPage(productListVO.getPageable().getPage(), productListVO.getPageable().getSize());
        List<Product> list = productMapper.findAll(productListVO);

        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Product> saveOrUpdate(ProductVO productVO) {
        //如果唯一编码为空,则生成
        if (StringUtils.isEmpty(productVO.getUnCode())) {
            productVO.setUnCode(UnCodeUtil.getUncode("PD"));
        }
        //新增产品，第一次入库
        Product product = new Product();
        product.setUnCode(productVO.getUnCode());
        product.setProdName(productVO.getProdName());
        product.setStock(productVO.getNum());
        productMapper.insert(product);
        //保存入库记录
        ProductOutInRecord productOutInRecord = new ProductOutInRecord();
        productOutInRecord.setProdId(product.getId());
        productOutInRecord.setType(1);
        productOutInRecord.setNum(productVO.getNum());
        productOutInRecord.setNote("新品入库");
        productMapper.saveRecord(productOutInRecord);
        //保存账单
        Bill bill = new Bill();
        bill.setType(1);
        bill.setUnCode(UnCodeUtil.getUncode("BILL"));
        bill.setAmount(productVO.getAmount());
        bill.setDetail("产品:" + productVO.getProdName() + "入库;PS:(prodId:" + product.getId() +
                ",recordId:" + productOutInRecord.getId() + ")");
        billMapper.insert(bill);
        return ResResult.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Product> storageOutIn(ProductOutInVO productOutInVO) {
        Product product = productMapper.findById(productOutInVO.getId());
        if (product == null) {
            throw new SassException("产品不存在");
        }
        int newStock = 0;
        Bill bill = new Bill();
        //入库
        if (productOutInVO.getType().equals(1)) {
            newStock = product.getStock() + productOutInVO.getNum();
            //入库保存 支出账单
            bill.setType(1);
            bill.setUnCode(UnCodeUtil.getUncode("BILL"));
            bill.setAmount(productOutInVO.getAmount());
        } else if (productOutInVO.getType().equals(2)) {
            newStock = product.getStock() - productOutInVO.getNum();
        }
        if (newStock < 0) {
            throw new SassException("产品库存有误");
        }
        Product newproduct = new Product();
        newproduct.setId(product.getId());
        newproduct.setStock(newStock);
        productMapper.update(newproduct);

        //保存记录
        ProductOutInRecord productOutInRecord = new ProductOutInRecord();
        productOutInRecord.setProdId(newproduct.getId());
        productOutInRecord.setType(productOutInVO.getType());
        productOutInRecord.setNum(productOutInVO.getNum());
        productOutInRecord.setNote(productOutInVO.getNote());
        productMapper.saveRecord(productOutInRecord);

        bill.setDetail("产品:" + product.getProdName() + "入库;PS:(prodId:" + product.getId() +
                ",recordId:" + productOutInRecord.getId() + ")");
        billMapper.insert(bill);
        return ResResult.ok();
    }


    @Override
    public PageInfo<ProductOutInRecordDTO> outInRecodeList(ProductOutInListVO productOutInListVO) {
        PageHelper.startPage(productOutInListVO.getPageable().getPage(), productOutInListVO.getPageable().getSize());
        List<ProductOutInRecordDTO> list = productMapper.findOutInRecordList(productOutInListVO);

        return new PageInfo<>(list);
    }
}
