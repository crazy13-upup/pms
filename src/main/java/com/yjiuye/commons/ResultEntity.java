package com.yjiuye.commons;
import java.util.HashMap;
import java.util.Map;

public class ResultEntity {

    public Map<String,Object> map = new HashMap<>();


    public ResultEntity put(String s,Object obj){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.map.put(s,obj);
        return resultEntity;
    }

    public static  ResultEntity success(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.map.put("statusCode",200);
        resultEntity.map.put("msg","响应成功");
        return resultEntity;
    }

    public static  ResultEntity error(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.map.put("statusCode",200);
        resultEntity.map.put("msg","响应成功");
        return resultEntity;
    }



}
