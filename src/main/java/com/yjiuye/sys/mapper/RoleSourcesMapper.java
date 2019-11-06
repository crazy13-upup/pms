package com.yjiuye.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface RoleSourcesMapper {
    void insert(@Param("rid") Integer roleid, @Param("sid") int parseInt);
}
