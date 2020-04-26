package com.customize.service.service.sys;

import com.customize.domain.dto.sys.ResourceDto;
import com.customize.domain.entity.sys.Resource;
import com.customize.domain.vo.sys.ResourceVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 资源表 sys_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface IResourceService extends BaseService<Resource, String> {

    /**
     * 分页条件查询资源
     */
    Page<ResourceDto> queryResourcePage(ResourceVo resourceVo);

    /**
     * 条件查询资源
     */
    List<ResourceDto> queryResourceList(ResourceVo resourceVo);

    /**
     * 查询所有资源
     */
    List<ResourceDto> selectResourceList();

    /**
     * 根据ID查询资源
     */
	ResourceDto findById(String pkResourceId);

    /**
     * 根据ID移除资源（逻辑删除）
     */
    int removeByPrimaryKey(String pkResourceId);

    /**
     * 批量移除资源（逻辑删除）
     */
    int removeResourceBatch(String[] pkResourceIds);

    /**
     * 批量删除资源（物理删除）
     */
    int deleteResourceBatch(String[] pkResourceIds);
}
