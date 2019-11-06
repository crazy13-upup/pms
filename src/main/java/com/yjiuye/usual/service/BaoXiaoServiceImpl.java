package com.yjiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjiuye.usual.bean.Baoxiao;
import com.yjiuye.usual.bean.BaoxiaoExample;
import com.yjiuye.usual.mapper.BaoxiaoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BaoXiaoServiceImpl implements BaoXiaoService {
    @Resource
    private BaoxiaoMapper baoxiaoMapper;

    @Override
    public void insertBaoXiao(Baoxiao baoxiao) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        baoxiao.setBxid(s);
        baoxiao.setBxstatus(0);
        baoxiaoMapper.insert(baoxiao);
    }

    @Override
    public PageInfo<Baoxiao> getBaoXiaoList(Integer eid, Integer pageNum, Map<String,Object> map) {
        //设置分页一般在service层，
        PageHelper.startPage(pageNum,3);
        BaoxiaoExample baoxiaoExample = new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = baoxiaoExample.createCriteria();
        Map<String,String> mybatisMap =parseMapToMybatisMap(map);
        String status = mybatisMap.get("status");
        String keyword = mybatisMap.get("keyword");
        if(status != null && status != ""){
            criteria.andBxstatusEqualTo(Integer.parseInt(status));
        }
        if(keyword != null &&keyword != ""){
            criteria.andBxremarkLike(keyword);
        }
        //设置查询条件，当前登陆用户
        criteria.andEmpFkEqualTo(eid);
        List<Baoxiao> list = baoxiaoMapper.selectByExample(baoxiaoExample);
        PageInfo<Baoxiao> pageInfo = new PageInfo<>(list,5);
        return pageInfo;
    }

    private Map<String, String> parseMapToMybatisMap(Map<String, Object> map) {
        Map<String,String> resultMap = new HashMap<>();
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry:entries) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            if(key.contains("like")){
                key=key.substring(key.indexOf("_")+1);
                value="%"+value+"%";
            }
        resultMap.put(key,value);
        }
        return resultMap;
    }

}
