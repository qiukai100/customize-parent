package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.OrganizationVo;
import com.customize.domain.dto.sys.OrganizationDto;
import com.customize.service.service.sys.IOrganizationService;

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
@RequestMapping("sys/organization")
@Api(value = "sys/organization", description  = "组织管理接口")
public class OrganizationController extends BaseController {

    private final IOrganizationService organizationService;

    @Autowired
    public OrganizationController(IOrganizationService organizationService) throws Exception {
        this.organizationService = organizationService;
    }

    @ApiOperation("分页条件查询组织")
    @RequestMapping(method = RequestMethod.GET, value = "queryOrganizationPage")
    public Result queryOrganizationPage(OrganizationVo organizationVo) throws Exception {
        return success(organizationService.queryOrganizationPage(organizationVo));
    }

    @ApiOperation("条件查询组织")
    @RequestMapping(method = RequestMethod.GET, value = "queryOrganizationList")
    public Result queryOrganizationList(OrganizationVo organizationVo) throws Exception {
        return success(organizationService.queryOrganizationList(organizationVo));
    }

    @ApiOperation("查询所有组织")
    @RequestMapping(method = RequestMethod.GET, value = "selectOrganizationList")
    public Result selectOrganizationList() throws Exception {
        return success(organizationService.selectOrganizationList());
    }

    @ApiOperation("根据ID查询组织")
    @RequestMapping(method = RequestMethod.GET, value = "findOrganizationById/{pkOrganizationId}")
    public Result findById(@PathVariable("pkOrganizationId") String pkOrganizationId) {
        return success(organizationService.findById(pkOrganizationId));
    }

    @ApiOperation("新增组织")
    @RequestMapping(method = RequestMethod.POST, value = "insertOrganization")
    public Result insertOrganization(OrganizationDto organizationDto) throws Exception {
        return success(organizationService.insertSelective(organizationDto));
    }

    @ApiOperation("修改组织")
    @RequestMapping(method = RequestMethod.PUT, value = "updateOrganization")
    public Result updateOrganization(OrganizationDto organizationDto) throws Exception {
        return success(organizationService.updateByPrimaryKeySelective(organizationDto));
    }

    @ApiOperation("根据ID移除组织（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeOrganizationById/{pkOrganizationId}")
    public Result removeOrganizationById(@PathVariable("pkOrganizationId") String pkOrganizationId) throws Exception {
        return success(organizationService.removeByPrimaryKey(pkOrganizationId));
    }

    @ApiOperation("根据ID移除组织（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrganizationById/{pkOrganizationId}")
    public Result deleteOrganizationById(@PathVariable("pkOrganizationId") String pkOrganizationId) throws Exception {
        return success(organizationService.deleteByPrimaryKey(pkOrganizationId));
    }

    @ApiOperation("批量删除组织（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeOrganizationBatch")
    public Result removeOrganizationBatch(@RequestParam String[] pkOrganizationIds) throws Exception {
        return success(organizationService.removeOrganizationBatch(pkOrganizationIds));
    }

    @ApiOperation("批量删除组织（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrganizationBatch")
    public Result deleteOrganizationBatch(@RequestParam String[] pkOrganizationIds) throws Exception {
        return success(organizationService.deleteOrganizationBatch(pkOrganizationIds));
    }

}
