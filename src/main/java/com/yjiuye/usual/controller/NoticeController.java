package com.yjiuye.usual.controller;

import com.github.pagehelper.PageInfo;
import com.yjiuye.commons.ResultEntity;
import com.yjiuye.usual.bean.Notice;
import com.yjiuye.usual.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    //主键查
    @RequestMapping(value = "/getNoticeById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Notice getNoticeById(@PathVariable("id") Integer nid){
        Notice notice = noticeService.getNoticeById(nid);
        return notice;
    }

    //查询最新
    @RequestMapping("/getNewestNoticelist")
    @ResponseBody
    public ResultEntity getNewestNoticelist(){
        ResultEntity entity = noticeService.getNewestNoticelist();
        return entity;

    }
    //添加数据
    @RequestMapping(value = "/savaInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity savaInfo(Notice notice){
        notice.setNdate(new Date());
        noticeService.savaInfo(notice);
        ResultEntity entity = ResultEntity.success();
        return entity;
    }


    //异步查询
    @RequestMapping("/jsonList")
    @ResponseBody
    public ResultEntity getJsonList(@RequestParam(value="pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<Notice> page = noticeService.getJsonList(pageNum);
        ResultEntity entity = ResultEntity.success().put("page",page );
        return entity;
    }

}
