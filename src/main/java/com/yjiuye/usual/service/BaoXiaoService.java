package com.yjiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.yjiuye.usual.bean.Baoxiao;

import java.util.List;
import java.util.Map;

public interface BaoXiaoService {


    void insertBaoXiao(Baoxiao baoxiao);


    PageInfo<Baoxiao> getBaoXiaoList(Integer eid, Integer pageNum, Map<String,Object> map);

}
