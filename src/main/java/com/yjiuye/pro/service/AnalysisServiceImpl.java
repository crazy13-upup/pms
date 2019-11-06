package com.yjiuye.pro.service;

import com.yjiuye.pro.bean.Analysis;
import com.yjiuye.pro.bean.AnalysisExample;
import com.yjiuye.pro.mapper.AnalysisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private AnalysisMapper analysisMapper;

    @Override
    public void insertAnalysis(Analysis analysis) {
        analysisMapper.insert(analysis);
    }

    @Override
    public List<Analysis> getList() {
        List<Analysis> list = analysisMapper.selectByExample(new AnalysisExample());
        return list;
    }

    @Override
    public Analysis findAnalysisById(String proname) {
        Analysis analysis = analysisMapper.selectByPrimaryKey(Integer.parseInt(proname));
        return analysis;
    }

    @Override
    public Analysis findAnalyById(Integer id) {

        Analysis analysis = analysisMapper.selectByPrimaryKey(id);
        return analysis;
    }

}
