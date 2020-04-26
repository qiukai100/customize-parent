package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.ResourceDto;
import com.customize.domain.entity.sys.Resource;
import com.customize.domain.vo.sys.ResourceVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 资源表 sys_resource
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 条件查询资源
     */
    List<ResourceDto> queryResourceList(@Param("resourceVo") ResourceVo resourceVo);

    /**
     * 查询所有资源
     */
    List<ResourceDto> selectResourceList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询资源
     */
    ResourceDto findById(@Param("pkResourceId") String pkResourceId, Integer isDelete);

    /**
     * 根据ID移除资源（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkResourceId") String pkResourceId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除资源（逻辑删除）
     */
    int removeResourceBatch(@Param("pkResourceIds") String[] pkResourceIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除资源（物理删除）
     */
    int deleteResourceBatch(@Param("pkResourceIds") String[] pkResourceIds);
}
