package com.yjiuye.pro.service;

import com.yjiuye.pro.bean.Project;

import java.util.List;

public interface ProjectService {

    void insertProject(Project project);

    List<Project> getProjectList();

    Boolean batchDelete(Integer[] ids);

    Project getProject(Integer pid);

    void updateProject(Project project);

    List<Project> jsonListNoAna();

    List<Project> search(Integer cid, String keyword, Integer orderby);

    List<Project> jsonList1();
}
