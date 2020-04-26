package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.OrganizationDto;
import com.customize.domain.entity.sys.Organization;
import com.customize.domain.vo.sys.OrganizationVo;
import com.customize.mybatis.mapper.sys.OrganizationMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IOrganizationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, String> implements IOrganizationService {

    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationMapper organizationMapper) {
        super(organizationMapper);
        this.organizationMapper = organizationMapper;
    }

    @Override
    public Page<OrganizationDto> queryOrganizationPage(OrganizationVo organizationVo) {
        return PageHelper.startPage(organizationVo.getPageNum(), organizationVo.getPageSize()).doSelectPage(() -> organizationMapper.queryOrganizationList(organizationVo));
    }

    @Override
    public List<OrganizationDto> queryOrganizationList(OrganizationVo organizationVo) {
        return organizationMapper.queryOrganizationList(organizationVo);
    }

    @Override
    public List<OrganizationDto> selectOrganizationList() {
        return organizationMapper.selectOrganizationList(OptionEnum.YES.getVal());
    }

    @Override
    public OrganizationDto findById(String pkOrganizationId) {
        return organizationMapper.findById(pkOrganizationId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkOrganizationId) {
        return organizationMapper.removeByPrimaryKey(pkOrganizationId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeOrganizationBatch(String[] pkOrganizationIds) {
        return organizationMapper.removeOrganizationBatch(pkOrganizationIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteOrganizationBatch(String[] pkOrganizationIds) {
        return organizationMapper.deleteOrganizationBatch(pkOrganizationIds);
    }
}
