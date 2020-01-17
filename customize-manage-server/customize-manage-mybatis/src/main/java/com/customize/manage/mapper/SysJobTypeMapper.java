package com.customize.manage.mapper;

import com.customize.manage.core.BaseMapper;
import com.customize.manage.entity.sys.SysJobType;
import org.apache.ibatis.annotations.Param;

public interface SysJobTypeMapper extends BaseMapper<SysJobType, String> {

    SysJobType selectByPrimaryKey(@Param("id") String id);

}