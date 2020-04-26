package com.customize.service.service.re.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.re.SysRoleOrganizationDto;
import com.customize.domain.entity.re.SysRoleOrganization;
import com.customize.domain.vo.re.SysRoleOrganizationVo;
import com.customize.mybatis.mapper.re.SysRoleOrganizationMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.re.ISysRoleOrganizationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 关联角色组织表 re_sys_role_organization
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class SysRoleOrganizationServiceImpl extends BaseServiceImpl<SysRoleOrganization, String> implements ISysRoleOrganizationService {

    private final SysRoleOrganizationMapper sysRoleOrganizationMapper;

    @Autowired
    public SysRoleOrganizationServiceImpl(SysRoleOrganizationMapper sysRoleOrganizationMapper) {
        super(sysRoleOrganizationMapper);
        this.sysRoleOrganizationMapper = sysRoleOrganizationMapper;
    }

    @Override
    public Page<SysRoleOrganizationDto> querySysRoleOrganizationPage(SysRoleOrganizationVo sysRoleOrganizationVo) {
        return PageHelper.startPage(sysRoleOrganizationVo.getPageNum(), sysRoleOrganizationVo.getPageSize()).doSelectPage(() -> sysRoleOrganizationMapper.querySysRoleOrganizationList(sysRoleOrganizationVo));
    }

    @Override
    public List<SysRoleOrganizationDto> querySysRoleOrganizationList(SysRoleOrganizationVo sysRoleOrganizationVo) {
        return sysRoleOrganizationMapper.querySysRoleOrganizationList(sysRoleOrganizationVo);
    }

    @Override
    public List<SysRoleOrganizationDto> selectSysRoleOrganizationList() {
        return sysRoleOrganizationMapper.selectSysRoleOrganizationList(OptionEnum.YES.getVal());
    }

    @Override
    public SysRoleOrganizationDto findById(String pkReRoleOrganizationId) {
        return sysRoleOrganizationMapper.findById(pkReRoleOrganizationId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkReRoleOrganizationId) {
        return sysRoleOrganizationMapper.removeByPrimaryKey(pkReRoleOrganizationId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeSysRoleOrganizationBatch(String[] pkReRoleOrganizationIds) {
        return sysRoleOrganizationMapper.removeSysRoleOrganizationBatch(pkReRoleOrganizationIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteSysRoleOrganizationBatch(String[] pkReRoleOrganizationIds) {
        return sysRoleOrganizationMapper.deleteSysRoleOrganizationBatch(pkReRoleOrganizationIds);
    }
}
