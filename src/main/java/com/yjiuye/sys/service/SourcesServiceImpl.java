package com.yjiuye.sys.service;

import com.yjiuye.commons.ResultEntity;
import com.yjiuye.sys.bean.Sources;
import com.yjiuye.sys.bean.SourcesExample;
import com.yjiuye.sys.mapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourcesServiceImpl implements SourcesService {
    @Resource
    private SourcesMapper sourcesMapper;

    @Override
    public List<Sources> getListById(int i) {
        SourcesExample sourcesExample = new SourcesExample();
        SourcesExample.Criteria criteria = sourcesExample.createCriteria();
        criteria.andPidEqualTo(i);
        List<Sources> list = sourcesMapper.selectByExample(sourcesExample);
        return list;
    }

    @Override
    public void saveInfo(Sources sources) {
        sourcesMapper.insert(sources);
    }

    @Override
    public Sources getOneById(Integer id) {
        Sources sources = sourcesMapper.selectByPrimaryKey(id);
        return sources;
    }

    @Override
    public void updateInfo(Sources sources) {
        sourcesMapper.updateByPrimaryKeySelective(sources);
    }

    @Override
    public ResultEntity deleteInfo(Integer id) {
        sourcesMapper.deleteByPrimaryKey(id);
        ResultEntity success = ResultEntity.success();
        return success;
    }


}
