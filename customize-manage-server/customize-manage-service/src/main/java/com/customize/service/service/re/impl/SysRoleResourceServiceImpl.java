package com.customize.service.service.re.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.re.SysRoleResourceDto;
import com.customize.domain.entity.re.SysRoleResource;
import com.customize.domain.vo.re.SysRoleResourceVo;
import com.customize.mybatis.mapper.re.SysRoleResourceMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.re.ISysRoleResourceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 关联角色资源表 re_sys_role_resource
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class SysRoleResourceServiceImpl extends BaseServiceImpl<SysRoleResource, String> implements ISysRoleResourceService {

    private final SysRoleResourceMapper sysRoleResourceMapper;

    @Autowired
    public SysRoleResourceServiceImpl(SysRoleResourceMapper sysRoleResourceMapper) {
        super(sysRoleResourceMapper);
        this.sysRoleResourceMapper = sysRoleResourceMapper;
    }

    @Override
    public Page<SysRoleResourceDto> querySysRoleResourcePage(SysRoleResourceVo sysRoleResourceVo) {
        return PageHelper.startPage(sysRoleResourceVo.getPageNum(), sysRoleResourceVo.getPageSize()).doSelectPage(() -> sysRoleResourceMapper.querySysRoleResourceList(sysRoleResourceVo));
    }

    @Override
    public List<SysRoleResourceDto> querySysRoleResourceList(SysRoleResourceVo sysRoleResourceVo) {
        return sysRoleResourceMapper.querySysRoleResourceList(sysRoleResourceVo);
    }

    @Override
    public List<SysRoleResourceDto> selectSysRoleResourceList() {
        return sysRoleResourceMapper.selectSysRoleResourceList(OptionEnum.YES.getVal());
    }

    @Override
    public SysRoleResourceDto findById(String pkReRoleResourceId) {
        return sysRoleResourceMapper.findById(pkReRoleResourceId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkReRoleResourceId) {
        return sysRoleResourceMapper.removeByPrimaryKey(pkReRoleResourceId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeSysRoleResourceBatch(String[] pkReRoleResourceIds) {
        return sysRoleResourceMapper.removeSysRoleResourceBatch(pkReRoleResourceIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteSysRoleResourceBatch(String[] pkReRoleResourceIds) {
        return sysRoleResourceMapper.deleteSysRoleResourceBatch(pkReRoleResourceIds);
    }
}
