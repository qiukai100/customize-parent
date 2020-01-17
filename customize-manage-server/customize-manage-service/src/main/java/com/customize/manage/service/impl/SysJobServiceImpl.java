package com.customize.manage.service.impl;

import com.customize.manage.core.BaseServiceImpl;
import com.customize.manage.dto.SysJobDto;
import com.customize.manage.entity.sys.SysJob;
import com.customize.manage.mapper.SysJobMapper;
import com.customize.manage.service.SysJobService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysJobServiceImpl extends BaseServiceImpl<SysJob, String> implements SysJobService {

    @Resource
    private SysJobMapper sysJobMapper;

    @Override
    public Page<SysJob> queryJobPage(SysJob job, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sysJobMapper.selectJobList(job));
    }

    @Override
    public SysJob insertSelective(SysJob job) {
//        sysJobMapper.insertSelective(job);
        return job;
    }

    @Override
    public SysJobDto findById(String id) {
        return sysJobMapper.findById(id);
    }
}
