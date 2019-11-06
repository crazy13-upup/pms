package com.yjiuye.cust.controller;

import com.yjiuye.cust.bean.Customer;
import com.yjiuye.cust.service.CustService;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.utils.ExcleUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cust")
public class CustController {
    @Autowired
    private CustService custService;



    //上传excle
    @RequestMapping("/importExcle")
    @ResponseBody
    public Map<String,Object> importExcle(MultipartFile excle){
        Map<String,Object> map= new HashMap<>();
        List<Customer> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取到excle文件之后，解析excle
        try{
            InputStream inputStream = excle.getInputStream();
            Workbook wb = WorkbookFactory.create(inputStream);
            for(int k = 0;k < wb.getNumberOfSheets();k++){
                Sheet sheet = wb.getSheetAt(k);
                if(sheet != null){
                    for (int i = sheet.getFirstRowNum()+1; i <sheet.getLastRowNum() ; i++){
                        Row row = sheet.getRow(i);
                        Customer customer = new Customer();
                        //内层for循环代表某一行中的数据
                        if(row != null){
                            String comname = row.getCell(1).getStringCellValue();
                            customer.setComname(comname);
                            Date date = row.getCell(2).getDateCellValue();
                            String format = sdf.format(date);
                            Date addtime = sdf.parse(format);
                            customer.setAddtime(addtime);
                            double numericCellValue = row.getCell(3).getNumericCellValue();
                            BigDecimal bigDecimal = new BigDecimal(String.valueOf(numericCellValue));
                            String comphone = bigDecimal.toPlainString();
                            customer.setComphone(comphone);
                            list.add(customer);
                        }
                    }

                }
            }
            System.out.println(list);
            custService.batchInsert(list);
          //上传成功
            map.put("code",200);
            map.put("msg","上传成功");
            return map;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            map.put("code",500);
            map.put("msg","上传失败");
            return map;
        }
    }


    //异步请求查询某一个客户信息
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Customer selectCustomerById(@PathVariable("id") Integer id){
        Customer customer = custService.findCustomerById(id);
        return customer;

    }


    //异步请求查询客户list
    @RequestMapping(value="/jsonList",method=RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllJsonListCusu(){
        List<Customer> list = custService.getAllCusu();
        return list;
    }


    //搜索查询
    @RequestMapping(value="/search",method = RequestMethod.GET)
    public ModelAndView serach(Integer cid,String keyword,Integer orderby){
        List<Customer> list = custService.serach(cid,keyword,orderby);
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    //批量删除
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> batchDelete(@RequestParam("ids[]") Integer[] ids){
        System.out.println(ids);
        Boolean isSuccess =  custService.batchDelete(ids);
           Map<String,Object> map = new HashMap<>();
           if(isSuccess){
               map.put("statusCode",200);
               map.put("msg","删除成功");
           }else{
               map.put("statusCode",500);
               map.put("msg","删除失败");
           }
           return map;

        }

    //编辑修改数据
    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public String updateCustomerById(Customer customer){
        custService.updateCustomerById(customer);
        return "redirect:/cust/list";
    }

    //编辑某一个客户之前先将数据查询出来回填
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String selectCustomerById(@PathVariable("id") Integer id, Map<String,Object> map){
        Customer customer = custService.findCustomerById(id);
        map.put("customer",customer);
        return "customer-edit";
    }

    //查看某一个客户详情
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String findCustomerById(@PathVariable("id") Integer id, Map<String,Object> map){
        Customer customer = custService.findCustomerById(id);
        map.put("customer",customer);
        return "customer-look";
    }

    //添加客户信息
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public String insertCust(Customer customer){
        System.out.println(customer);
        custService.insertCust(customer);
        //添加成功跳转到查询
        return "redirect:/cust/list";
    }

    //点击客户管理查询到所有客户信息
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public ModelAndView getAllCusu(){
        ModelAndView modelAndView = new ModelAndView("customer");
        List<Customer> list = custService.getAllCusu();
        modelAndView.addObject("list",list);
        return modelAndView;
    }


}
