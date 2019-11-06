package com.yjiuye.sys.service;

import com.yjiuye.commons.ResultEntity;
import com.yjiuye.sys.bean.Sources;

import java.util.List;

public interface SourcesService {
    List<Sources> getListById(int i);

    void saveInfo(Sources sources);

    Sources getOneById(Integer id);

    void updateInfo(Sources sources);

    ResultEntity deleteInfo(Integer id);


}
