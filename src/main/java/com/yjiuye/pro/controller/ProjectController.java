package com.yjiuye.pro.controller;

import com.yjiuye.pro.bean.Project;
import com.yjiuye.pro.service.ProjectService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    //模糊查询
    @RequestMapping("/search")
    public ModelAndView search(Integer cid,String keyword,Integer orderby){
        List<Project> list = projectService.search(cid,keyword,orderby);
        ModelAndView modelAndView = new ModelAndView("project-base");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    //查询所有有需求分析的项目名称
    @RequestMapping("/jsonList1")
    @ResponseBody
    public Map<String,Object> jsonList1(){
       List<Project> list =  projectService.jsonList1();
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    //查询所有还没有需求分析的项目名称
    @RequestMapping("/jsonListNoAna")
    @ResponseBody
    public List<Project> jsonListNoAna(){
       List<Project> list =  projectService.jsonListNoAna();
       return list;
    }

    //异步查询list,导出excle
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getJsonList(){
        List<Project> list = projectService.getProjectList();
        HSSFWorkbook workbook= new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("表一");
        HSSFRow row = sheet.createRow(0);

        Cell[] cell = new HSSFCell[3];
        for (int i = 0; i < cell.length; i++) {
           cell[i] = row.createCell(i);
        }
        cell[0].setCellValue("ID");
        cell[1].setCellValue("项目名称");
        cell[2].setCellValue("项目开始时间");

        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            HSSFRow row1 = sheet.createRow(i+1);
            Cell[] cell1 = new HSSFCell[3];
            for (int j = 0; j < cell.length; j++) {
                cell1[j] = row1.createCell(j);
            }
            cell1[0].setCellValue(project.getPid());
            cell1[1].setCellValue(project.getPname());
            Date starttime = project.getStarttime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(starttime);
            cell1[2].setCellValue(format);

            FileOutputStream fileOutputStream = null;
            try{
                fileOutputStream = new FileOutputStream(new File("C:\\Users\\Administrator.ALJS-20180826YQ.000\\Desktop\\project.xls"));
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("msg","导出成功");
        return map;

    }
    //修改
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String updateProject(Project project){
        projectService.updateProject(project);
        return "redirect:/pro/list";
    }
    //编辑前查询
    @RequestMapping(value = "/edit/{pid}",method = RequestMethod.GET)
    public String getEditProject(@PathVariable("pid") Integer pid,Map<String,Object> map){
        Project project = projectService.getProject(pid);
        map.put("project",project);
        System.out.println(project.toString());
        return "project-base-edit";
    }

    //查看某一个详情
    @RequestMapping(value = "/info/{pid}",method = RequestMethod.GET)
    public String getProject(@PathVariable("pid") Integer pid,Map<String,Object> map){
        Project project = projectService.getProject(pid);
        map.put("project",project);
        return "project-base-look";
    }

    //批量删除
    @RequestMapping(value = "/batchDelete",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> batchDelete(@RequestParam("ids[]") Integer[] ids){
       Boolean isSuccess =  projectService.batchDelete(ids);
       Map<String,Object> map = new HashMap<>();
       if(isSuccess){
           map.put("msg","删除成功");
       }else{
           map.put("msg","删除失败");
       }
        return map;

    }

    //添加
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insertProject(Project project){
        projectService.insertProject(project);
        return "redirect:/pro/list";
    }

    //查询list
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getProjectList(){
        List<Project> list = projectService.getProjectList();
        ModelAndView modelAndView = new ModelAndView("project-base");
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
