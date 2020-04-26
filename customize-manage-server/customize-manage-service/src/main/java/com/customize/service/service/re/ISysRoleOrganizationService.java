package com.customize.service.service.re;

import com.customize.domain.dto.re.SysRoleOrganizationDto;
import com.customize.domain.entity.re.SysRoleOrganization;
import com.customize.domain.vo.re.SysRoleOrganizationVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 关联角色组织表 re_sys_role_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface ISysRoleOrganizationService extends BaseService<SysRoleOrganization, String> {

    /**
     * 分页条件查询关联角色组织
     */
    Page<SysRoleOrganizationDto> querySysRoleOrganizationPage(SysRoleOrganizationVo sysRoleOrganizationVo);

    /**
     * 条件查询关联角色组织
     */
    List<SysRoleOrganizationDto> querySysRoleOrganizationList(SysRoleOrganizationVo sysRoleOrganizationVo);

    /**
     * 查询所有关联角色组织
     */
    List<SysRoleOrganizationDto> selectSysRoleOrganizationList();

    /**
     * 根据ID查询关联角色组织
     */
	SysRoleOrganizationDto findById(String pkReRoleOrganizationId);

    /**
     * 根据ID移除关联角色组织（逻辑删除）
     */
    int removeByPrimaryKey(String pkReRoleOrganizationId);

    /**
     * 批量移除关联角色组织（逻辑删除）
     */
    int removeSysRoleOrganizationBatch(String[] pkReRoleOrganizationIds);

    /**
     * 批量删除关联角色组织（物理删除）
     */
    int deleteSysRoleOrganizationBatch(String[] pkReRoleOrganizationIds);
}
