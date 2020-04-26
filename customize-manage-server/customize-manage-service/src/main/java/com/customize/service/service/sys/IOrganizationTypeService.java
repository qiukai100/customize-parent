package com.customize.service.service.sys;

import com.customize.domain.dto.sys.OrganizationTypeDto;
import com.customize.domain.entity.sys.OrganizationType;
import com.customize.domain.vo.sys.OrganizationTypeVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 组织类型表 sys_organization_type
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface IOrganizationTypeService extends BaseService<OrganizationType, String> {

    /**
     * 分页条件查询组织类型
     */
    Page<OrganizationTypeDto> queryOrganizationTypePage(OrganizationTypeVo organizationTypeVo);

    /**
     * 条件查询组织类型
     */
    List<OrganizationTypeDto> queryOrganizationTypeList(OrganizationTypeVo organizationTypeVo);

    /**
     * 查询所有组织类型
     */
    List<OrganizationTypeDto> selectOrganizationTypeList();

    /**
     * 根据ID查询组织类型
     */
	OrganizationTypeDto findById(String pkOrganizationTypeId);

    /**
     * 根据ID移除组织类型（逻辑删除）
     */
    int removeByPrimaryKey(String pkOrganizationTypeId);

    /**
     * 批量移除组织类型（逻辑删除）
     */
    int removeOrganizationTypeBatch(String[] pkOrganizationTypeIds);

    /**
     * 批量删除组织类型（物理删除）
     */
    int deleteOrganizationTypeBatch(String[] pkOrganizationTypeIds);
}
