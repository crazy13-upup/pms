package com.yjiuye.cust.service;


import com.yjiuye.cust.bean.Customer;
import com.yjiuye.sys.bean.Employee;

import java.util.List;

public interface CustService {
    void insertCust(Customer customer);


    List<Customer> getAllCusu();

    Customer findCustomerById(Integer id);

    void updateCustomerById(Customer customer);

    Boolean batchDelete(Integer[] ids);

    List<Customer> serach(Integer cid, String keyword, Integer orderby);

    void batchInsert(List<Customer> list);


}
