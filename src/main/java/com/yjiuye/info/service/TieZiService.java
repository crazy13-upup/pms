package com.yjiuye.info.service;

import com.yjiuye.usual.bean.Forumpost;
import org.springframework.stereotype.Service;

@Service
public interface TieZiService {
    void saveInfo(Forumpost forumpost);
}
