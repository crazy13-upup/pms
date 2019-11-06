package com.yjiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjiuye.commons.ResultEntity;
import com.yjiuye.usual.bean.Notice;
import com.yjiuye.usual.bean.NoticeExample;
import com.yjiuye.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;


    @Override
    public void savaInfo(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public PageInfo<Notice> getJsonList(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Notice> list = noticeMapper.selectByExample(new NoticeExample());
        PageInfo<Notice> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public ResultEntity getNewestNoticelist() {
        NoticeExample noticeExample = new NoticeExample();
        noticeExample.setOrderByClause("ndate desc limit 3");
        List<Notice> list = noticeMapper.selectByExample(noticeExample);
        ResultEntity entity = ResultEntity.success().put("list", list);
        return entity;

    }

    @Override
    public Notice getNoticeById(Integer nid) {
        Notice notice = noticeMapper.selectByPrimaryKey(nid);
        return notice;
    }


}
