package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.RoleVo;
import com.customize.domain.dto.sys.RoleDto;
import com.customize.service.service.sys.IRoleService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 角色表 sys_role
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("sys/role")
public class RoleController extends BaseController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) throws Exception {
        this.roleService = roleService;
    }

    /**
     * 分页条件查询角色
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryRolePage")
    public Result queryRolePage(RoleVo roleVo) throws Exception {
        return success(roleService.queryRolePage(roleVo));
    }

    /**
     * 条件查询角色
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryRoleList")
    public Result queryRoleList(RoleVo roleVo) throws Exception {
        return success(roleService.queryRoleList(roleVo));
    }

    /**
     * 查询所有角色
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectRoleList")
    public Result selectRoleList() throws Exception {
        return success(roleService.selectRoleList());
    }

    /**
     * 根据ID查询角色
     */
    @RequestMapping(method = RequestMethod.GET, value = "findRoleById/{pkRoleId}")
    public Result findById(@PathVariable("pkRoleId") String pkRoleId) {
        return success(roleService.findById(pkRoleId));
    }

    /**
     * 新增角色
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertRole")
    public Result insertRole(RoleDto roleDto) throws Exception {
        return success(roleService.insertSelective(roleDto));
    }

    /**
     * 修改角色
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateRole")
    public Result updateRole(RoleDto roleDto) throws Exception {
        return success(roleService.updateByPrimaryKeySelective(roleDto));
    }

    /**
     * 根据ID移除角色（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeRoleById/{pkRoleId}")
    public Result removeRoleById(@PathVariable("pkRoleId") String pkRoleId) throws Exception {
        return success(roleService.removeByPrimaryKey(pkRoleId));
    }

    /**
     * 根据ID移除角色（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRoleById/{pkRoleId}")
    public Result deleteRoleById(@PathVariable("pkRoleId") String pkRoleId) throws Exception {
        return success(roleService.deleteByPrimaryKey(pkRoleId));
    }

    /**
     * 批量删除角色（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeRoleBatch")
    public Result removeRoleBatch(@RequestParam String[] pkRoleIds) throws Exception {
        return success(roleService.removeRoleBatch(pkRoleIds));
    }

    /**
     * 批量删除角色（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRoleBatch")
    public Result deleteRoleBatch(@RequestParam String[] pkRoleIds) throws Exception {
        return success(roleService.deleteRoleBatch(pkRoleIds));
    }

}
