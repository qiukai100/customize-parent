package com.customize.mybatis.mapper.re;

import com.customize.domain.dto.re.SysRoleOrganizationDto;
import com.customize.domain.entity.re.SysRoleOrganization;
import com.customize.domain.vo.re.SysRoleOrganizationVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 关联角色组织表 re_sys_role_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface SysRoleOrganizationMapper extends BaseMapper<SysRoleOrganization> {

    /**
     * 条件查询关联角色组织
     */
    List<SysRoleOrganizationDto> querySysRoleOrganizationList(@Param("sysRoleOrganizationVo") SysRoleOrganizationVo sysRoleOrganizationVo);

    /**
     * 查询所有关联角色组织
     */
    List<SysRoleOrganizationDto> selectSysRoleOrganizationList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询关联角色组织
     */
    SysRoleOrganizationDto findById(@Param("pkReRoleOrganizationId") String pkReRoleOrganizationId, Integer isDelete);

    /**
     * 根据ID移除关联角色组织（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkReRoleOrganizationId") String pkReRoleOrganizationId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除关联角色组织（逻辑删除）
     */
    int removeSysRoleOrganizationBatch(@Param("pkReRoleOrganizationIds") String[] pkReRoleOrganizationIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除关联角色组织（物理删除）
     */
    int deleteSysRoleOrganizationBatch(@Param("pkReRoleOrganizationIds") String[] pkReRoleOrganizationIds);
}
