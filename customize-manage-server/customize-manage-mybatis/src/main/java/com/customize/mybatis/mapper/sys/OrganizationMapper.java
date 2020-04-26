package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.OrganizationDto;
import com.customize.domain.entity.sys.Organization;
import com.customize.domain.vo.sys.OrganizationVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    /**
     * 条件查询组织
     */
    List<OrganizationDto> queryOrganizationList(@Param("organizationVo") OrganizationVo organizationVo);

    /**
     * 查询所有组织
     */
    List<OrganizationDto> selectOrganizationList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询组织
     */
    OrganizationDto findById(@Param("pkOrganizationId") String pkOrganizationId, Integer isDelete);

    /**
     * 根据ID移除组织（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkOrganizationId") String pkOrganizationId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除组织（逻辑删除）
     */
    int removeOrganizationBatch(@Param("pkOrganizationIds") String[] pkOrganizationIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除组织（物理删除）
     */
    int deleteOrganizationBatch(@Param("pkOrganizationIds") String[] pkOrganizationIds);
}
