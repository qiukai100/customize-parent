package com.customize.web.controller.re;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.re.SysRoleOrganizationVo;
import com.customize.domain.dto.re.SysRoleOrganizationDto;
import com.customize.service.service.re.ISysRoleOrganizationService;

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
@RequestMapping("re/sysRoleOrganization")
@Api(value = "re/sysRoleOrganization", description  = "关联角色组织管理接口")
public class SysRoleOrganizationController extends BaseController {

    private final ISysRoleOrganizationService sysRoleOrganizationService;

    @Autowired
    public SysRoleOrganizationController(ISysRoleOrganizationService sysRoleOrganizationService) throws Exception {
        this.sysRoleOrganizationService = sysRoleOrganizationService;
    }

    @ApiOperation("分页条件查询关联角色组织")
    @RequestMapping(method = RequestMethod.GET, value = "querySysRoleOrganizationPage")
    public Result querySysRoleOrganizationPage(SysRoleOrganizationVo sysRoleOrganizationVo) throws Exception {
        return success(sysRoleOrganizationService.querySysRoleOrganizationPage(sysRoleOrganizationVo));
    }

    @ApiOperation("条件查询关联角色组织")
    @RequestMapping(method = RequestMethod.GET, value = "querySysRoleOrganizationList")
    public Result querySysRoleOrganizationList(SysRoleOrganizationVo sysRoleOrganizationVo) throws Exception {
        return success(sysRoleOrganizationService.querySysRoleOrganizationList(sysRoleOrganizationVo));
    }

    @ApiOperation("查询所有关联角色组织")
    @RequestMapping(method = RequestMethod.GET, value = "selectSysRoleOrganizationList")
    public Result selectSysRoleOrganizationList() throws Exception {
        return success(sysRoleOrganizationService.selectSysRoleOrganizationList());
    }

    @ApiOperation("根据ID查询关联角色组织")
    @RequestMapping(method = RequestMethod.GET, value = "findSysRoleOrganizationById/{pkReRoleOrganizationId}")
    public Result findById(@PathVariable("pkReRoleOrganizationId") String pkReRoleOrganizationId) {
        return success(sysRoleOrganizationService.findById(pkReRoleOrganizationId));
    }

    @ApiOperation("新增关联角色组织")
    @RequestMapping(method = RequestMethod.POST, value = "insertSysRoleOrganization")
    public Result insertSysRoleOrganization(SysRoleOrganizationDto sysRoleOrganizationDto) throws Exception {
        return success(sysRoleOrganizationService.insertSelective(sysRoleOrganizationDto));
    }

    @ApiOperation("修改关联角色组织")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSysRoleOrganization")
    public Result updateSysRoleOrganization(SysRoleOrganizationDto sysRoleOrganizationDto) throws Exception {
        return success(sysRoleOrganizationService.updateByPrimaryKeySelective(sysRoleOrganizationDto));
    }

    @ApiOperation("根据ID移除关联角色组织（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysRoleOrganizationById/{pkReRoleOrganizationId}")
    public Result removeSysRoleOrganizationById(@PathVariable("pkReRoleOrganizationId") String pkReRoleOrganizationId) throws Exception {
        return success(sysRoleOrganizationService.removeByPrimaryKey(pkReRoleOrganizationId));
    }

    @ApiOperation("根据ID移除关联角色组织（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysRoleOrganizationById/{pkReRoleOrganizationId}")
    public Result deleteSysRoleOrganizationById(@PathVariable("pkReRoleOrganizationId") String pkReRoleOrganizationId) throws Exception {
        return success(sysRoleOrganizationService.deleteByPrimaryKey(pkReRoleOrganizationId));
    }

    @ApiOperation("批量删除关联角色组织（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysRoleOrganizationBatch")
    public Result removeSysRoleOrganizationBatch(@RequestParam String[] pkReRoleOrganizationIds) throws Exception {
        return success(sysRoleOrganizationService.removeSysRoleOrganizationBatch(pkReRoleOrganizationIds));
    }

    @ApiOperation("批量删除关联角色组织（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysRoleOrganizationBatch")
    public Result deleteSysRoleOrganizationBatch(@RequestParam String[] pkReRoleOrganizationIds) throws Exception {
        return success(sysRoleOrganizationService.deleteSysRoleOrganizationBatch(pkReRoleOrganizationIds));
    }

}
