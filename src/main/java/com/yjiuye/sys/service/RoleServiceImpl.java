package com.yjiuye.sys.service;

import com.yjiuye.commons.ResultEntity;
import com.yjiuye.sys.bean.Role;
import com.yjiuye.sys.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    @Override
    public int saveInfo(Role role) {
        roleMapper.saveInfo(role);
        return role.getRoleid();
    }
}
