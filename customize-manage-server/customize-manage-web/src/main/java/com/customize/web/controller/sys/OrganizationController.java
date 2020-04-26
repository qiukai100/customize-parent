package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.OrganizationVo;
import com.customize.domain.dto.sys.OrganizationDto;
import com.customize.service.service.sys.IOrganizationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 组织表 sys_organization
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("sys/organization")
public class OrganizationController extends BaseController {

    private final IOrganizationService organizationService;

    @Autowired
    public OrganizationController(IOrganizationService organizationService) throws Exception {
        this.organizationService = organizationService;
    }

    /**
     * 分页条件查询组织
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryOrganizationPage")
    public Result queryOrganizationPage(OrganizationVo organizationVo) throws Exception {
        return success(organizationService.queryOrganizationPage(organizationVo));
    }

    /**
     * 条件查询组织
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryOrganizationList")
    public Result queryOrganizationList(OrganizationVo organizationVo) throws Exception {
        return success(organizationService.queryOrganizationList(organizationVo));
    }

    /**
     * 查询所有组织
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectOrganizationList")
    public Result selectOrganizationList() throws Exception {
        return success(organizationService.selectOrganizationList());
    }

    /**
     * 根据ID查询组织
     */
    @RequestMapping(method = RequestMethod.GET, value = "findOrganizationById/{pkOrganizationId}")
    public Result findById(@PathVariable("pkOrganizationId") String pkOrganizationId) {
        return success(organizationService.findById(pkOrganizationId));
    }

    /**
     * 新增组织
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertOrganization")
    public Result insertOrganization(OrganizationDto organizationDto) throws Exception {
        return success(organizationService.insertSelective(organizationDto));
    }

    /**
     * 修改组织
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateOrganization")
    public Result updateOrganization(OrganizationDto organizationDto) throws Exception {
        return success(organizationService.updateByPrimaryKeySelective(organizationDto));
    }

    /**
     * 根据ID移除组织（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeOrganizationById/{pkOrganizationId}")
    public Result removeOrganizationById(@PathVariable("pkOrganizationId") String pkOrganizationId) throws Exception {
        return success(organizationService.removeByPrimaryKey(pkOrganizationId));
    }

    /**
     * 根据ID移除组织（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrganizationById/{pkOrganizationId}")
    public Result deleteOrganizationById(@PathVariable("pkOrganizationId") String pkOrganizationId) throws Exception {
        return success(organizationService.deleteByPrimaryKey(pkOrganizationId));
    }

    /**
     * 批量删除组织（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeOrganizationBatch")
    public Result removeOrganizationBatch(@RequestParam String[] pkOrganizationIds) throws Exception {
        return success(organizationService.removeOrganizationBatch(pkOrganizationIds));
    }

    /**
     * 批量删除组织（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrganizationBatch")
    public Result deleteOrganizationBatch(@RequestParam String[] pkOrganizationIds) throws Exception {
        return success(organizationService.deleteOrganizationBatch(pkOrganizationIds));
    }

}
