package com.yjiuye.info.service;

import com.yjiuye.info.bean.Email;
import com.yjiuye.info.mapper.EmailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private EmailMapper emailMapper;

    @Override
    public void saveInfo(Email email) {
        emailMapper.insert(email);
    }
}
