package com.customize.manage.mapper;

import com.customize.manage.core.BaseMapper;
import com.customize.manage.dto.SysJobDto;
import com.customize.manage.entity.sys.SysJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysJobMapper extends BaseMapper<SysJob, String> {

    List<SysJob> selectJobList(@Param("sysJob") SysJob sysJob);

    SysJobDto findById(String id);
}