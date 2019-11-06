package com.yjiuye.cust.service;

import com.yjiuye.cust.bean.Customer;
import com.yjiuye.cust.bean.CustomerExample;
import com.yjiuye.cust.mapper.CustomerMapper;


import com.yjiuye.sys.bean.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CustServiceImpl implements CustService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public void insertCust(Customer customer) {

        customer.setAddtime(new Date());
        customerMapper.insert(customer);
    }

    @Override
    public List<Customer> getAllCusu() {
        List<Customer> list = customerMapper.selectByExample(new CustomerExample());
        return list;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public void updateCustomerById(Customer customer) {
      customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public Boolean batchDelete(Integer[] ids) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        List<Integer> list = Arrays.asList(ids);
        criteria.andIdIn(list);
        int i = customerMapper.deleteByExample(customerExample);
        if(i == list.size()){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> serach(Integer cid, String keyword, Integer orderby) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        if(cid ==0){
            criteria.andComnameLike("%"+keyword+"%");
            CustomerExample.Criteria criteria1 = customerExample.createCriteria();
            criteria1.andCompanypersonLike("%"+keyword+"%");
            customerExample.or(criteria1);
        }else if(cid ==1 ){
            criteria.andComnameLike("%"+keyword+"%");
        }else{
            criteria.andCompanypersonLike("%"+keyword+"%");
        }

        if(orderby == 1){
            customerExample.setOrderByClause("id desc");
        }
        List<Customer> list = customerMapper.selectByExample(customerExample);
        return list;
    }

    @Override
    public void batchInsert(List<Customer> list) {
        customerMapper.batchInsert(list);
    }




}
