package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.ResourceVo;
import com.customize.domain.dto.sys.ResourceDto;
import com.customize.service.service.sys.IResourceService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 资源表 sys_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("sys/resource")
public class ResourceController extends BaseController {

    private final IResourceService resourceService;

    @Autowired
    public ResourceController(IResourceService resourceService) throws Exception {
        this.resourceService = resourceService;
    }

    /**
     * 分页条件查询资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryResourcePage")
    public Result queryResourcePage(ResourceVo resourceVo) throws Exception {
        return success(resourceService.queryResourcePage(resourceVo));
    }

    /**
     * 条件查询资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryResourceList")
    public Result queryResourceList(ResourceVo resourceVo) throws Exception {
        return success(resourceService.queryResourceList(resourceVo));
    }

    /**
     * 查询所有资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectResourceList")
    public Result selectResourceList() throws Exception {
        return success(resourceService.selectResourceList());
    }

    /**
     * 根据ID查询资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "findResourceById/{pkResourceId}")
    public Result findById(@PathVariable("pkResourceId") String pkResourceId) {
        return success(resourceService.findById(pkResourceId));
    }

    /**
     * 新增资源
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertResource")
    public Result insertResource(ResourceDto resourceDto) throws Exception {
        return success(resourceService.insertSelective(resourceDto));
    }

    /**
     * 修改资源
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateResource")
    public Result updateResource(ResourceDto resourceDto) throws Exception {
        return success(resourceService.updateByPrimaryKeySelective(resourceDto));
    }

    /**
     * 根据ID移除资源（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeResourceById/{pkResourceId}")
    public Result removeResourceById(@PathVariable("pkResourceId") String pkResourceId) throws Exception {
        return success(resourceService.removeByPrimaryKey(pkResourceId));
    }

    /**
     * 根据ID移除资源（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteResourceById/{pkResourceId}")
    public Result deleteResourceById(@PathVariable("pkResourceId") String pkResourceId) throws Exception {
        return success(resourceService.deleteByPrimaryKey(pkResourceId));
    }

    /**
     * 批量删除资源（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeResourceBatch")
    public Result removeResourceBatch(@RequestParam String[] pkResourceIds) throws Exception {
        return success(resourceService.removeResourceBatch(pkResourceIds));
    }

    /**
     * 批量删除资源（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteResourceBatch")
    public Result deleteResourceBatch(@RequestParam String[] pkResourceIds) throws Exception {
        return success(resourceService.deleteResourceBatch(pkResourceIds));
    }

}
