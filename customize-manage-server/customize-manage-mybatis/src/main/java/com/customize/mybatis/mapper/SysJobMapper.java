package com.customize.mybatis.mapper;

import com.customize.mybatis.core.BaseMapper;
import com.customize.domain.dto.SysJobDto;
import com.customize.domain.entity.sys.SysJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysJobMapper extends BaseMapper<SysJob> {

    List<SysJob> selectJobList(@Param("sysJob") SysJob sysJob);

    SysJobDto findById(String id);
}