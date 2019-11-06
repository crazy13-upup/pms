package com.yjiuye.sys.controller;

import com.yjiuye.commons.ResultEntity;
import com.yjiuye.sys.bean.Role;
import com.yjiuye.sys.service.RoleService;
import com.yjiuye.sys.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Autowired
    private RoleSourcesService roleSourcesService;

    @RequestMapping("/saveInfo")
    @ResponseBody
    public ResultEntity saveInfo(Role role ,String ids){
        int roleid = roleService.saveInfo(role);
        String[] split = ids.split(",");
        for (int i = 0 ;i < split.length ;i++){
            roleSourcesService.insert(role.getRoleid(),Integer.parseInt(split[i]));
        }
        ResultEntity resultEntity = ResultEntity.success();
        return resultEntity;
    }
}
