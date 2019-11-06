package com.yjiuye.sys.service;

import com.yjiuye.sys.mapper.RoleSourcesMapper;
import com.yjiuye.sys.service.RoleSourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {


  @Resource
  private RoleSourcesMapper roleSourcesMapper;


    @Override
    public void insert(Integer roleid, int parseInt) {
        roleSourcesMapper.insert(roleid,parseInt);
    }
}
