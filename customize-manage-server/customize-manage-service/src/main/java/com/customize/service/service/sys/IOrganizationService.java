package com.customize.service.service.sys;

import com.customize.domain.dto.sys.OrganizationDto;
import com.customize.domain.entity.sys.Organization;
import com.customize.domain.vo.sys.OrganizationVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface IOrganizationService extends BaseService<Organization, String> {

    /**
     * 分页条件查询组织
     */
    Page<OrganizationDto> queryOrganizationPage(OrganizationVo organizationVo);

    /**
     * 条件查询组织
     */
    List<OrganizationDto> queryOrganizationList(OrganizationVo organizationVo);

    /**
     * 查询所有组织
     */
    List<OrganizationDto> selectOrganizationList();

    /**
     * 根据ID查询组织
     */
	OrganizationDto findById(String pkOrganizationId);

    /**
     * 根据ID移除组织（逻辑删除）
     */
    int removeByPrimaryKey(String pkOrganizationId);

    /**
     * 批量移除组织（逻辑删除）
     */
    int removeOrganizationBatch(String[] pkOrganizationIds);

    /**
     * 批量删除组织（物理删除）
     */
    int deleteOrganizationBatch(String[] pkOrganizationIds);
}
