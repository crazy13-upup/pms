package com.yjiuye.pro.service;

import com.yjiuye.pro.bean.Function;
import com.yjiuye.pro.bean.FunctionExample;
import com.yjiuye.pro.mapper.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public List<Function> getFunctionList(Integer modeleFk) {
        FunctionExample functionExample = new FunctionExample();
        FunctionExample.Criteria criteria = functionExample.createCriteria();
        criteria.andModeleFkEqualTo(modeleFk);
        List<Function> list = functionMapper.selectByExample(functionExample);
        return list;
    }
}
