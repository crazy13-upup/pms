package com.yjiuye.pro.service;


import com.yjiuye.pro.bean.Module;

import java.util.List;

public interface ModuleService {


    void insertModu(Module module);

    List<Module> getModuleList();

    List<Module> findModule(Integer analysisFk);
}
