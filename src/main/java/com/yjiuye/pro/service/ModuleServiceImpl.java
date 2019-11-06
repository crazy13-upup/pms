package com.yjiuye.pro.service;

import com.yjiuye.pro.bean.Module;
import com.yjiuye.pro.bean.ModuleExample;
import com.yjiuye.pro.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleMapper moduleMapper;


    @Override
    public void insertModu(Module module) {
        moduleMapper.insert(module);
    }

    @Override
    public List<Module> getModuleList() {
        List<Module> list = moduleMapper.getModuleList();
        return list;
    }

    @Override
    public List<Module> findModule(Integer analysisFk) {
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAnalysisFkEqualTo(analysisFk);
        List<Module> list =  moduleMapper.selectByExample(moduleExample);
       return list;
    }
}
