package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.ResourceDto;
import com.customize.domain.entity.sys.Resource;
import com.customize.domain.vo.sys.ResourceVo;
import com.customize.mybatis.mapper.sys.ResourceMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IResourceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 资源表 sys_resource
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, String> implements IResourceService {

    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper) {
        super(resourceMapper);
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Page<ResourceDto> queryResourcePage(ResourceVo resourceVo) {
        return PageHelper.startPage(resourceVo.getPageNum(), resourceVo.getPageSize()).doSelectPage(() -> resourceMapper.queryResourceList(resourceVo));
    }

    @Override
    public List<ResourceDto> queryResourceList(ResourceVo resourceVo) {
        return resourceMapper.queryResourceList(resourceVo);
    }

    @Override
    public List<ResourceDto> selectResourceList() {
        return resourceMapper.selectResourceList(OptionEnum.YES.getVal());
    }

    @Override
    public ResourceDto findById(String pkResourceId) {
        return resourceMapper.findById(pkResourceId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkResourceId) {
        return resourceMapper.removeByPrimaryKey(pkResourceId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeResourceBatch(String[] pkResourceIds) {
        return resourceMapper.removeResourceBatch(pkResourceIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteResourceBatch(String[] pkResourceIds) {
        return resourceMapper.deleteResourceBatch(pkResourceIds);
    }
}
