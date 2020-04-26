package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.OrganizationTypeDto;
import com.customize.domain.entity.sys.OrganizationType;
import com.customize.domain.vo.sys.OrganizationTypeVo;
import com.customize.mybatis.mapper.sys.OrganizationTypeMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IOrganizationTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 组织类型表 sys_organization_type
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@Service
public class OrganizationTypeServiceImpl extends BaseServiceImpl<OrganizationType, String> implements IOrganizationTypeService {

    private final OrganizationTypeMapper organizationTypeMapper;

    @Autowired
    public OrganizationTypeServiceImpl(OrganizationTypeMapper organizationTypeMapper) {
        super(organizationTypeMapper);
        this.organizationTypeMapper = organizationTypeMapper;
    }

    @Override
    public Page<OrganizationTypeDto> queryOrganizationTypePage(OrganizationTypeVo organizationTypeVo) {
        return PageHelper.startPage(organizationTypeVo.getPageNum(), organizationTypeVo.getPageSize()).doSelectPage(() -> organizationTypeMapper.queryOrganizationTypeList(organizationTypeVo));
    }

    @Override
    public List<OrganizationTypeDto> queryOrganizationTypeList(OrganizationTypeVo organizationTypeVo) {
        return organizationTypeMapper.queryOrganizationTypeList(organizationTypeVo);
    }

    @Override
    public List<OrganizationTypeDto> selectOrganizationTypeList() {
        return organizationTypeMapper.selectOrganizationTypeList(OptionEnum.YES.getVal());
    }

    @Override
    public OrganizationTypeDto findById(String pkOrganizationTypeId) {
        return organizationTypeMapper.findById(pkOrganizationTypeId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkOrganizationTypeId) {
        return organizationTypeMapper.removeByPrimaryKey(pkOrganizationTypeId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeOrganizationTypeBatch(String[] pkOrganizationTypeIds) {
        return organizationTypeMapper.removeOrganizationTypeBatch(pkOrganizationTypeIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteOrganizationTypeBatch(String[] pkOrganizationTypeIds) {
        return organizationTypeMapper.deleteOrganizationTypeBatch(pkOrganizationTypeIds);
    }
}
