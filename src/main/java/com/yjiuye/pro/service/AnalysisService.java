package com.yjiuye.pro.service;

import com.yjiuye.pro.bean.Analysis;

import java.util.List;

public interface AnalysisService {
    void insertAnalysis(Analysis analysis);

    List<Analysis> getList();

    Analysis findAnalysisById(String proname);


    Analysis findAnalyById(Integer id);
}
