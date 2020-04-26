package com.customize.mybatis.mapper.re;

import com.customize.domain.dto.re.SysRoleResourceDto;
import com.customize.domain.entity.re.SysRoleResource;
import com.customize.domain.vo.re.SysRoleResourceVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 关联角色资源表 re_sys_role_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {

    /**
     * 条件查询关联角色资源
     */
    List<SysRoleResourceDto> querySysRoleResourceList(@Param("sysRoleResourceVo") SysRoleResourceVo sysRoleResourceVo);

    /**
     * 查询所有关联角色资源
     */
    List<SysRoleResourceDto> selectSysRoleResourceList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询关联角色资源
     */
    SysRoleResourceDto findById(@Param("pkReRoleResourceId") String pkReRoleResourceId, Integer isDelete);

    /**
     * 根据ID移除关联角色资源（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkReRoleResourceId") String pkReRoleResourceId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除关联角色资源（逻辑删除）
     */
    int removeSysRoleResourceBatch(@Param("pkReRoleResourceIds") String[] pkReRoleResourceIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除关联角色资源（物理删除）
     */
    int deleteSysRoleResourceBatch(@Param("pkReRoleResourceIds") String[] pkReRoleResourceIds);
}
