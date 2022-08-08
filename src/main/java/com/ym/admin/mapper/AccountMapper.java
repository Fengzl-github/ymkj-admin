package com.ym.admin.mapper;

import com.ym.admin.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Fengzl
 * @Date 2022/7/23 19:17
 * @Desc
 **/
@Repository
public interface AccountMapper {

//    /**
//     * 查询全部
//     * @param customerListVO
//     * @return
//     */
//    List<CustomerAccountDTO> findAll(CustomerListVO customerListVO);

    /**
     * 新增或修改
     * @param account
     */
    void insertOrUpdate(Account account);


    /**
     * 根据id获取
     * @param id
     * @return
     */
    Account findById(@Param("id") Integer id);

    /**
     * 根据客户id获取
     * @param csmId
     * @return
     */
    Account findByCsmId(@Param("csmId")Integer csmId);
}
