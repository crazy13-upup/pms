package com.yjiuye.pro.service;

import com.yjiuye.cust.bean.Customer;
import com.yjiuye.cust.mapper.CustomerMapper;
import com.yjiuye.pro.bean.Project;
import com.yjiuye.pro.bean.ProjectExample;
import com.yjiuye.pro.mapper.ProjectMapper;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.sys.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private EmployeeMapper employeeMapper;


    @Override
    public void insertProject(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> getProjectList() {
        List<Project> list = projectMapper.selectByExample(new ProjectExample());
        for (Project p:list) {
            Integer comname = p.getComname();
            Customer customer = customerMapper.selectByPrimaryKey(comname);
            p.setCustomer(customer);
            Integer empFk = p.getEmpFk();
            Employee employee = employeeMapper.selectByPrimaryKey(empFk);
            p.setEmployee(employee);
        }
        return list;
    }

    @Override
    public Boolean batchDelete(Integer[] ids) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        List<Integer> list = Arrays.asList(ids);
        criteria.andPidIn(list);
        int i = projectMapper.deleteByExample(projectExample);
        if(i == ids.length){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Project getProject(Integer pid) {
        Project project = projectMapper.selectByPrimaryKey(pid);
        Integer comname = project.getComname();
        Customer customer = customerMapper.selectByPrimaryKey(comname);
        project.setCustomer(customer);
        Integer empFk = project.getEmpFk();
        Employee employee = employeeMapper.selectByPrimaryKey(empFk);
        project.setEmployee(employee);
        return project;
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public List<Project> jsonListNoAna() {
        List<Project> list =  projectMapper.jsonListNoAna();
        return list;
    }

    @Override
    public List<Project> search(Integer cid, String keyword, Integer orderby) {
        List<Project> list = projectMapper.search(cid,keyword,orderby);
        return list;
    }

    @Override
    public List<Project> jsonList1() {

       List<Project> list =  projectMapper.jsonList1();
       return list;
    }
}
