package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.OrganizationTypeDto;
import com.customize.domain.entity.sys.OrganizationType;
import com.customize.domain.vo.sys.OrganizationTypeVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 组织类型表 sys_organization_type
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface OrganizationTypeMapper extends BaseMapper<OrganizationType> {

    /**
     * 条件查询组织类型
     */
    List<OrganizationTypeDto> queryOrganizationTypeList(@Param("organizationTypeVo") OrganizationTypeVo organizationTypeVo);

    /**
     * 查询所有组织类型
     */
    List<OrganizationTypeDto> selectOrganizationTypeList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询组织类型
     */
    OrganizationTypeDto findById(@Param("pkOrganizationTypeId") String pkOrganizationTypeId, Integer isDelete);

    /**
     * 根据ID移除组织类型（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkOrganizationTypeId") String pkOrganizationTypeId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除组织类型（逻辑删除）
     */
    int removeOrganizationTypeBatch(@Param("pkOrganizationTypeIds") String[] pkOrganizationTypeIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除组织类型（物理删除）
     */
    int deleteOrganizationTypeBatch(@Param("pkOrganizationTypeIds") String[] pkOrganizationTypeIds);
}
