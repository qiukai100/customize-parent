package com.customize.mybatis.mapper;

import com.customize.mybatis.core.BaseMapper;
import com.customize.domain.entity.sys.SysJobType;
import org.apache.ibatis.annotations.Param;

public interface SysJobTypeMapper extends BaseMapper<SysJobType> {

    SysJobType findById(@Param("id") String id);

}