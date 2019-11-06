package com.yjiuye.sys.service;

import com.yjiuye.info.bean.Email;
import com.yjiuye.sys.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Employee selectEmp(Employee employee);

    List<Employee> getEmployee(Integer eid);


}
