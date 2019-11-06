package com.yjiuye.pro.service;

import com.yjiuye.pro.bean.Function;

import java.util.List;

public interface FunctionService {
    List<Function> getFunctionList(Integer modeleFk);
}
