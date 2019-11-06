package com.yjiuye.pro.controller;

import com.yjiuye.pro.bean.Module;
import com.yjiuye.pro.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mod")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    //findModule 查询某一个需求下面的模块
    @RequestMapping("/findModule{analysisFk}")
    @ResponseBody
    public Map<String,Object> findModule(@PathVariable("analysisFk") Integer analysisFk){
        List<Module> list = moduleService.findModule(analysisFk);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",list);
        return map;


    }

    //查询所有
    @RequestMapping("/list")
    public ModelAndView getModuleList(){
        List<Module> list = moduleService.getModuleList();
        ModelAndView modelAndView = new ModelAndView("project-model");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    //添加
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public String insertModu(Module module){
        moduleService.insertModu(module);
        return "redirect:/mod/list";
    }
}
