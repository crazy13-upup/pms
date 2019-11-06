package com.yjiuye.pro.controller;

import com.yjiuye.pro.bean.Function;
import com.yjiuye.pro.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/func")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

   @RequestMapping(value = "/getFunctionList{id}",method = RequestMethod.GET)
   @ResponseBody
    public Map<String,Object> getFunctionList(@PathVariable("id") Integer modeleFk){
        List<Function> list = functionService.getFunctionList(modeleFk);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return map;

    }
}
