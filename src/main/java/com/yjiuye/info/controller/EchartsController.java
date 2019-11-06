package com.yjiuye.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/echarts")
public class EchartsController {
    @RequestMapping("/info")
    @ResponseBody
    public Map<String,Object> info(){

        Map<String,Object> map = new HashMap<>();
        map.put("衬衫",5);
        map.put("羊毛衫",20);
        map.put("裤子",30);
        map.put("高跟鞋",10);
        return map;

    }
}
