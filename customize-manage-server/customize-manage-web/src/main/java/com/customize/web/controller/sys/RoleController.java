package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.RoleVo;
import com.customize.domain.dto.sys.RoleDto;
import com.customize.service.service.sys.IRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@RestController
@RequestMapping("sys/role")
@Api(value = "sys/role", description  = "角色管理接口")
public class RoleController extends BaseController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) throws Exception {
        this.roleService = roleService;
    }

    @ApiOperation("分页条件查询角色")
    @RequestMapping(method = RequestMethod.GET, value = "queryRolePage")
    public Result queryRolePage(RoleVo roleVo) throws Exception {
        return success(roleService.queryRolePage(roleVo));
    }

    @ApiOperation("条件查询角色")
    @RequestMapping(method = RequestMethod.GET, value = "queryRoleList")
    public Result queryRoleList(RoleVo roleVo) throws Exception {
        return success(roleService.queryRoleList(roleVo));
    }

    @ApiOperation("查询所有角色")
    @RequestMapping(method = RequestMethod.GET, value = "selectRoleList")
    public Result selectRoleList() throws Exception {
        return success(roleService.selectRoleList());
    }

    @ApiOperation("根据ID查询角色")
    @RequestMapping(method = RequestMethod.GET, value = "findRoleById/{pkRoleId}")
    public Result findById(@PathVariable("pkRoleId") String pkRoleId) {
        return success(roleService.findById(pkRoleId));
    }

    @ApiOperation("新增角色")
    @RequestMapping(method = RequestMethod.POST, value = "insertRole")
    public Result insertRole(RoleDto roleDto) throws Exception {
        return success(roleService.insertSelective(roleDto));
    }

    @ApiOperation("修改角色")
    @RequestMapping(method = RequestMethod.PUT, value = "updateRole")
    public Result updateRole(RoleDto roleDto) throws Exception {
        return success(roleService.updateByPrimaryKeySelective(roleDto));
    }

    @ApiOperation("根据ID移除角色（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeRoleById/{pkRoleId}")
    public Result removeRoleById(@PathVariable("pkRoleId") String pkRoleId) throws Exception {
        return success(roleService.removeByPrimaryKey(pkRoleId));
    }

    @ApiOperation("根据ID移除角色（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRoleById/{pkRoleId}")
    public Result deleteRoleById(@PathVariable("pkRoleId") String pkRoleId) throws Exception {
        return success(roleService.deleteByPrimaryKey(pkRoleId));
    }

    @ApiOperation("批量删除角色（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeRoleBatch")
    public Result removeRoleBatch(@RequestParam String[] pkRoleIds) throws Exception {
        return success(roleService.removeRoleBatch(pkRoleIds));
    }

    @ApiOperation("批量删除角色（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRoleBatch")
    public Result deleteRoleBatch(@RequestParam String[] pkRoleIds) throws Exception {
        return success(roleService.deleteRoleBatch(pkRoleIds));
    }

}
