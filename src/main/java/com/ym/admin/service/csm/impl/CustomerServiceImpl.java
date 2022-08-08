package com.ym.admin.service.csm.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ym.admin.common.exception.SassException;
import com.ym.admin.common.res.ResResult;
import com.ym.admin.convert.CustomerConvert;
import com.ym.admin.dto.cbo.RecordListDTO;
import com.ym.admin.dto.csm.CustomerAccountDTO;
import com.ym.admin.dto.csm.CustomerGstRecordDTO;
import com.ym.admin.entity.*;
import com.ym.admin.mapper.*;
import com.ym.admin.service.csm.CustomerService;
import com.ym.admin.util.ClassCompareUtil;
import com.ym.admin.util.UnCodeUtil;
import com.ym.admin.vo.RecordListVO;
import com.ym.admin.vo.csm.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private CustomerPayMapper customerPayMapper;
    @Resource
    private ComboMapper comboMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private BillMapper billMapper;

    @Override
    public PageInfo<CustomerAccountDTO> list(CustomerListVO customerListVO) {

        PageHelper.startPage(customerListVO.getPageable().getPage(), customerListVO.getPageable().getSize());
        List<CustomerAccountDTO> list = customerMapper.findAll(customerListVO);

        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Customer> saveOrUpdate(CustomerVO customerVO) {
        //如果唯一编码为空,则生成
        if (StringUtils.isEmpty(customerVO.getUnCode())) {
            customerVO.setUnCode(UnCodeUtil.getUncode("CM"));
        }
        if (Objects.nonNull(customerVO.getId())) {
            Customer customer = customerMapper.findById(customerVO.getId());
            Optional.ofNullable(customer).orElseThrow(() -> new SassException("客户不存在"));
            Customer newCustomer = CustomerConvert.INSTANCE.toCustomer(customerVO);
            List<Map<String, Object>> maps = ClassCompareUtil.compareFields(customer, newCustomer, new String[]{"csmName", "mobile", "type", "sex", "age"});
            if (!maps.get(0).isEmpty()) {
                CustomerChangeRecord record = new CustomerChangeRecord(customer.getId(), maps);
                customerMapper.saveRecord(record);
            }
        }
        customerMapper.insertOrUpdate(customerVO);

        return ResResult.ok();
    }

    @Override
    public ResResult<Customer> updateDeleted(Integer id, Integer deleted) {

        customerMapper.updateDeleted(id, deleted);

        return ResResult.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Customer> savePayAmount(PayAmountVO params) {

        Customer customer = customerMapper.findById(params.getId());
        if (customer == null) {
            throw new SassException("客户信息不存在");
        }
        Account saveAcc = new Account();
        Account account = accountMapper.findByCsmId(params.getId());
        if (account == null) {
            saveAcc.setUnCode(UnCodeUtil.getUncode("AC"));
            saveAcc.setCsmId(customer.getId());
            saveAcc.setBalance(params.getPayAmount());
        } else {
            saveAcc.setId(account.getId());
            BigDecimal newBalance = account.getBalance().add(params.getPayAmount());
            saveAcc.setBalance(newBalance);
        }
        accountMapper.insertOrUpdate(saveAcc);

        CustomerPayRecord payRecord = new CustomerPayRecord();
        payRecord.setType(1);
        payRecord.setCsmId(customer.getId());
        payRecord.setAmount(params.getPayAmount());
        payRecord.setNote("储值卡充值");
        customerPayMapper.insertPayRecord(payRecord);

        return ResResult.ok();
    }


    @Override
    public PageInfo<RecordListDTO> record(RecordListVO recordListVO) {
        PageHelper.startPage(recordListVO.getPageable().getPage(), recordListVO.getPageable().getSize());
        List<RecordListDTO> list = customerMapper.findAllRecord(recordListVO);

        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<CustomerGstRecordDTO> payRrecord(GstRecordListVO gstRecordListVO) {

        PageHelper.startPage(gstRecordListVO.getPageable().getPage(), gstRecordListVO.getPageable().getSize());
        List<CustomerGstRecordDTO> list = customerPayMapper.findPayRecord(gstRecordListVO);

        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Customer> payCombo(PayComboVO params) {

        Customer customer = customerMapper.findById(params.getCsmId());
        Optional.ofNullable(customer).orElseThrow(() -> new SassException("客户不存在"));
        Combo combo = comboMapper.findById(params.getCboId());
        Optional.ofNullable(combo).orElseThrow(() -> new SassException("套餐不存在"));

        CustomerCombo customerCombo = new CustomerCombo(customer, combo);
        customerCombo.setAmount(params.getAmount());
        customerCombo.setPayWay(params.getPayWay());
        customerPayMapper.insertCustomerCombo(customerCombo);
        String strNote = "客户:" + customer.getCsmName() + "通过:" + (params.getPayWay().equals(1) ? "线下支付" : "储值卡支付") + "购买套餐:" + combo.getCboName() + "(套餐编码:" + combo.getUnCode() + ")";
        //生成消费记录
        CustomerPayRecord payRecord = new CustomerPayRecord();
        payRecord.setType(2);
        payRecord.setCsmId(customer.getId());
        payRecord.setAmount(params.getAmount());
        payRecord.setNote(strNote);
        customerPayMapper.insertPayRecord(payRecord);
        if (params.getPayWay().equals(1)) {
            //生成账单
            Bill bill = new Bill();
            bill.setType(2);
            bill.setUnCode(UnCodeUtil.getUncode("BILL"));
            bill.setAmount(params.getAmount());
            bill.setDetail(strNote);
            billMapper.insert(bill);
        } else {
            Account account = accountMapper.findByCsmId(customer.getId());
            Optional.ofNullable(account).orElseThrow(() -> new SassException("客户账户不存在,无法使用储值卡"));
            BigDecimal newBalance = account.getBalance().subtract(params.getAmount());
            if (newBalance.compareTo(new BigDecimal(0)) < 0) {
                throw new SassException("储值卡余额不足");
            }
            account.setBalance(newBalance);
            accountMapper.insertOrUpdate(account);
        }

        return ResResult.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<Customer> payProject(PayProjectVO params) {
        Customer customer = customerMapper.findById(params.getCsmId());
        Optional.ofNullable(customer).orElseThrow(() -> new SassException("客户不存在"));
        Project project = projectMapper.findById(params.getProId());
        Optional.ofNullable(project).orElseThrow(() -> new SassException("项目不存在"));

        CustomerProject customerProject = new CustomerProject(customer, project);
        customerProject.setAmount(params.getAmount());
        customerPayMapper.insertCustomerProject(customerProject);
        String strNote = "客户:" + customer.getCsmName() + "通过:" + (params.getPayWay().equals(1) ? "线下支付" : "储值卡支付") + "购买项目:" + project.getProName() + "(项目编码:" + project.getUnCode() + ")";
        //生成消费记录
        CustomerPayRecord payRecord = new CustomerPayRecord();
        payRecord.setType(2);
        payRecord.setCsmId(customer.getId());
        payRecord.setAmount(params.getAmount());
        payRecord.setNote(strNote);
        customerPayMapper.insertPayRecord(payRecord);
        if (params.getPayWay().equals(1)) {
            //生成账单
            Bill bill = new Bill();
            bill.setType(2);
            bill.setUnCode(UnCodeUtil.getUncode("BILL"));
            bill.setAmount(params.getAmount());
            bill.setDetail(strNote);
            billMapper.insert(bill);
        } else {
            Account account = accountMapper.findByCsmId(customer.getId());
            Optional.ofNullable(account).orElseThrow(() -> new SassException("客户账户不存在,无法使用储值卡"));
            BigDecimal newBalance = account.getBalance().subtract(params.getAmount());
            if (newBalance.compareTo(new BigDecimal(0)) < 0) {
                throw new SassException("储值卡余额不足");
            }
            account.setBalance(newBalance);
            accountMapper.insertOrUpdate(account);
        }
        return ResResult.ok();
    }

    @Override
    public ResResult<List<CustomerCombo>> getCanUseCombo(Integer csmId) {

        List<CustomerCombo> list = customerPayMapper.getCanUseCombo(csmId);
        return ResResult.ok(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResResult<CustomerCombo> comboCutDown(ComboCutVO comboCutVO) {

        CustomerCombo customerCombo = customerPayMapper.findById(comboCutVO.getId());
        Optional.ofNullable(customerCombo).orElseThrow(() -> new SassException("套餐记录不存在"));
        int remainNum = customerCombo.getLastNum() - comboCutVO.getNum();
        if (remainNum < 0) {
            throw new SassException("剩余套餐使用次数小于1");
        }
        CustomerCombo saveDate = new CustomerCombo();
        saveDate.setId(comboCutVO.getId());
        saveDate.setLastNum(remainNum);
        if (remainNum == 0) {
            saveDate.setStatus(1);
        }
        customerPayMapper.updateCustomerCombo(saveDate);

        //套餐使用次数消减记录
        CustomerUseComboRecord useComboRecord = new CustomerUseComboRecord(customerCombo);
        customerPayMapper.insertUseComboRecord(useComboRecord);

        return ResResult.ok();
    }


    @Override
    public ResResult<List<CustomerUseComboRecord>> getUseComboRecord(Integer ccId) {

        List<CustomerUseComboRecord> useComboRecord = customerPayMapper.getUseComboRecord(ccId);

        return ResResult.ok(useComboRecord);
    }
}
