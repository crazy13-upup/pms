package com.yjiuye.sys.controller;

import com.yjiuye.commons.ResultEntity;
import com.yjiuye.sys.bean.Sources;
import com.yjiuye.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/source")
public class SourcesController {
    @Autowired
    private SourcesService sourcesService;

    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultEntity deleteInfo(Integer id){
        ResultEntity result = sourcesService.deleteInfo(id);
        return result;
    }

    //修改
    @RequestMapping(value = "/updateInfo",method = RequestMethod.PUT)
    public String updateInfo(Sources sources){
        sourcesService.updateInfo(sources);
        return "redirect:/pm.jsp";
    }

    //查询ById
    @RequestMapping(value = "/getOneById",method = RequestMethod.GET)
    public ModelAndView getOneById(Integer id){
        Sources sources = sourcesService.getOneById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pm-edit");
        modelAndView.addObject("onesource",sources);
        return modelAndView;
    }

    //添加
    @RequestMapping("/saveInfo")
    public String saveInfo(Sources sources){
        sourcesService.saveInfo(sources);
        return "redirect:/pm.jsp";


    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Sources> getList(){
        //获取到顶级父节点
        List<Sources> list = sourcesService.getListById(0);
        queryList(list.get(0));
        return list;
    }

    //递归
    private void queryList(Sources source) {
        Integer id = source.getId();
        List<Sources> sources = sourcesService.getListById(id);
        for (Sources sources1:sources) {
            queryList(sources1);
        }
        source.setChildren(sources);



    }


}
