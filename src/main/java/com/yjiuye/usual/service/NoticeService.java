package com.yjiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.yjiuye.commons.ResultEntity;
import com.yjiuye.usual.bean.Notice;

import java.util.List;

public interface NoticeService {

    void savaInfo(Notice notice);


    PageInfo<Notice> getJsonList(Integer pageNum);

    ResultEntity getNewestNoticelist();

    Notice getNoticeById(Integer nid);
}
