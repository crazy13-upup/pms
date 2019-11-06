package com.yjiuye.pro.controller;

import com.yjiuye.pro.bean.Analysis;
import com.yjiuye.pro.bean.Project;
import com.yjiuye.pro.service.AnalysisService;
import com.yjiuye.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/analy")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;

    //异步查询某一个需求分析
    @RequestMapping("/findAnalyById{id}")
    @ResponseBody
    public Map<String,Object> findAnalyById(@PathVariable("id") Integer id){
        Analysis analysis = analysisService.findAnalyById(id);
        Map<String,Object> map  = new HashMap<>();
        map.put("analysis",analysis);
        return map;
    }



    //添加
    @RequestMapping("/insert")
    public String insertAnalysis(Analysis analysis){
        String proname = analysis.getProname();
        String[] split = proname.split(",");
        Integer id = Integer.parseInt(split[0]);
        analysis.setId(id);
        String s1 = split[1];
        analysis.setProname(s1);
        analysis.setAddtime(new Date());
        analysisService.insertAnalysis(analysis);
        return "redirect:/analy/list";
    }


    //同步查询list
    @RequestMapping("/list")
    public ModelAndView getList(){
       List<Analysis> list =  analysisService.getList();
       ModelAndView modelAndView = new ModelAndView("project-need");
       modelAndView.addObject("list",list);
       return modelAndView;
    }
}
