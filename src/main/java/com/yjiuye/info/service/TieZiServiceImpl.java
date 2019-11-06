package com.yjiuye.info.service;

import com.yjiuye.usual.bean.Forumpost;
import com.yjiuye.usual.mapper.ForumpostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TieZiServiceImpl implements TieZiService {
    @Resource
    private ForumpostMapper forumpostMapper;

    @Override
    public void saveInfo(Forumpost forumpost) {
        forumpostMapper.insert(forumpost);
    }
}
