package com.customize.web.controller.re;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.re.SysRoleResourceVo;
import com.customize.domain.dto.re.SysRoleResourceDto;
import com.customize.service.service.re.ISysRoleResourceService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 关联角色资源表 re_sys_role_resource
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("re/sysRoleResource")
public class SysRoleResourceController extends BaseController {

    private final ISysRoleResourceService sysRoleResourceService;

    @Autowired
    public SysRoleResourceController(ISysRoleResourceService sysRoleResourceService) throws Exception {
        this.sysRoleResourceService = sysRoleResourceService;
    }

    /**
     * 分页条件查询关联角色资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "querySysRoleResourcePage")
    public Result querySysRoleResourcePage(SysRoleResourceVo sysRoleResourceVo) throws Exception {
        return success(sysRoleResourceService.querySysRoleResourcePage(sysRoleResourceVo));
    }

    /**
     * 条件查询关联角色资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "querySysRoleResourceList")
    public Result querySysRoleResourceList(SysRoleResourceVo sysRoleResourceVo) throws Exception {
        return success(sysRoleResourceService.querySysRoleResourceList(sysRoleResourceVo));
    }

    /**
     * 查询所有关联角色资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectSysRoleResourceList")
    public Result selectSysRoleResourceList() throws Exception {
        return success(sysRoleResourceService.selectSysRoleResourceList());
    }

    /**
     * 根据ID查询关联角色资源
     */
    @RequestMapping(method = RequestMethod.GET, value = "findSysRoleResourceById/{pkReRoleResourceId}")
    public Result findById(@PathVariable("pkReRoleResourceId") String pkReRoleResourceId) {
        return success(sysRoleResourceService.findById(pkReRoleResourceId));
    }

    /**
     * 新增关联角色资源
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertSysRoleResource")
    public Result insertSysRoleResource(SysRoleResourceDto sysRoleResourceDto) throws Exception {
        return success(sysRoleResourceService.insertSelective(sysRoleResourceDto));
    }

    /**
     * 修改关联角色资源
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateSysRoleResource")
    public Result updateSysRoleResource(SysRoleResourceDto sysRoleResourceDto) throws Exception {
        return success(sysRoleResourceService.updateByPrimaryKeySelective(sysRoleResourceDto));
    }

    /**
     * 根据ID移除关联角色资源（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysRoleResourceById/{pkReRoleResourceId}")
    public Result removeSysRoleResourceById(@PathVariable("pkReRoleResourceId") String pkReRoleResourceId) throws Exception {
        return success(sysRoleResourceService.removeByPrimaryKey(pkReRoleResourceId));
    }

    /**
     * 根据ID移除关联角色资源（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysRoleResourceById/{pkReRoleResourceId}")
    public Result deleteSysRoleResourceById(@PathVariable("pkReRoleResourceId") String pkReRoleResourceId) throws Exception {
        return success(sysRoleResourceService.deleteByPrimaryKey(pkReRoleResourceId));
    }

    /**
     * 批量删除关联角色资源（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysRoleResourceBatch")
    public Result removeSysRoleResourceBatch(@RequestParam String[] pkReRoleResourceIds) throws Exception {
        return success(sysRoleResourceService.removeSysRoleResourceBatch(pkReRoleResourceIds));
    }

    /**
     * 批量删除关联角色资源（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysRoleResourceBatch")
    public Result deleteSysRoleResourceBatch(@RequestParam String[] pkReRoleResourceIds) throws Exception {
        return success(sysRoleResourceService.deleteSysRoleResourceBatch(pkReRoleResourceIds));
    }

}
