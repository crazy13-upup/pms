package com.yjiuye.sys.service;

import com.yjiuye.info.bean.Email;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.sys.bean.EmployeeExample;
import com.yjiuye.sys.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeList() {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andPFkEqualTo(4);
        List<Employee> list = employeeMapper.selectByExample(employeeExample);
        return list;
    }

    @Override
    public Employee selectEmp(Employee employee) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        criteria.andPasswordEqualTo(employee.getPassword());
        List<Employee> list = employeeMapper.selectByExample(employeeExample);
       if(list != null &&list.size()!= 0){
           Employee employee1 = list.get(0);
           return employee1;
       }
       return null;

    }

    @Override
    public List<Employee> getEmployee(Integer eid) {
       List<Employee> list = employeeMapper.getEmployee(eid);
       return list;
    }




}
