package com.customize.web.controller.re;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.re.SysUserRoleVo;
import com.customize.domain.dto.re.SysUserRoleDto;
import com.customize.service.service.re.ISysUserRoleService;

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
@RequestMapping("re/sysUserRole")
@Api(value = "re/sysUserRole", description  = "关联用户角色管理接口")
public class SysUserRoleController extends BaseController {

    private final ISysUserRoleService sysUserRoleService;

    @Autowired
    public SysUserRoleController(ISysUserRoleService sysUserRoleService) throws Exception {
        this.sysUserRoleService = sysUserRoleService;
    }

    @ApiOperation("分页条件查询关联用户角色")
    @RequestMapping(method = RequestMethod.GET, value = "querySysUserRolePage")
    public Result querySysUserRolePage(SysUserRoleVo sysUserRoleVo) throws Exception {
        return success(sysUserRoleService.querySysUserRolePage(sysUserRoleVo));
    }

    @ApiOperation("条件查询关联用户角色")
    @RequestMapping(method = RequestMethod.GET, value = "querySysUserRoleList")
    public Result querySysUserRoleList(SysUserRoleVo sysUserRoleVo) throws Exception {
        return success(sysUserRoleService.querySysUserRoleList(sysUserRoleVo));
    }

    @ApiOperation("查询所有关联用户角色")
    @RequestMapping(method = RequestMethod.GET, value = "selectSysUserRoleList")
    public Result selectSysUserRoleList() throws Exception {
        return success(sysUserRoleService.selectSysUserRoleList());
    }

    @ApiOperation("根据ID查询关联用户角色")
    @RequestMapping(method = RequestMethod.GET, value = "findSysUserRoleById/{pkReUserRoleId}")
    public Result findById(@PathVariable("pkReUserRoleId") String pkReUserRoleId) {
        return success(sysUserRoleService.findById(pkReUserRoleId));
    }

    @ApiOperation("新增关联用户角色")
    @RequestMapping(method = RequestMethod.POST, value = "insertSysUserRole")
    public Result insertSysUserRole(SysUserRoleDto sysUserRoleDto) throws Exception {
        return success(sysUserRoleService.insertSelective(sysUserRoleDto));
    }

    @ApiOperation("修改关联用户角色")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSysUserRole")
    public Result updateSysUserRole(SysUserRoleDto sysUserRoleDto) throws Exception {
        return success(sysUserRoleService.updateByPrimaryKeySelective(sysUserRoleDto));
    }

    @ApiOperation("根据ID移除关联用户角色（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysUserRoleById/{pkReUserRoleId}")
    public Result removeSysUserRoleById(@PathVariable("pkReUserRoleId") String pkReUserRoleId) throws Exception {
        return success(sysUserRoleService.removeByPrimaryKey(pkReUserRoleId));
    }

    @ApiOperation("根据ID移除关联用户角色（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysUserRoleById/{pkReUserRoleId}")
    public Result deleteSysUserRoleById(@PathVariable("pkReUserRoleId") String pkReUserRoleId) throws Exception {
        return success(sysUserRoleService.deleteByPrimaryKey(pkReUserRoleId));
    }

    @ApiOperation("批量删除关联用户角色（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysUserRoleBatch")
    public Result removeSysUserRoleBatch(@RequestParam String[] pkReUserRoleIds) throws Exception {
        return success(sysUserRoleService.removeSysUserRoleBatch(pkReUserRoleIds));
    }

    @ApiOperation("批量删除关联用户角色（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysUserRoleBatch")
    public Result deleteSysUserRoleBatch(@RequestParam String[] pkReUserRoleIds) throws Exception {
        return success(sysUserRoleService.deleteSysUserRoleBatch(pkReUserRoleIds));
    }

}
