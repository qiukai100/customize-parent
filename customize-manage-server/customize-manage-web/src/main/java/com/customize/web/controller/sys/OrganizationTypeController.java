package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.OrganizationTypeVo;
import com.customize.domain.dto.sys.OrganizationTypeDto;
import com.customize.service.service.sys.IOrganizationTypeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 组织类型表 sys_organization_type
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("sys/organizationType")
public class OrganizationTypeController extends BaseController {

    private final IOrganizationTypeService organizationTypeService;

    @Autowired
    public OrganizationTypeController(IOrganizationTypeService organizationTypeService) throws Exception {
        this.organizationTypeService = organizationTypeService;
    }

    /**
     * 分页条件查询组织类型
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryOrganizationTypePage")
    public Result queryOrganizationTypePage(OrganizationTypeVo organizationTypeVo) throws Exception {
        return success(organizationTypeService.queryOrganizationTypePage(organizationTypeVo));
    }

    /**
     * 条件查询组织类型
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryOrganizationTypeList")
    public Result queryOrganizationTypeList(OrganizationTypeVo organizationTypeVo) throws Exception {
        return success(organizationTypeService.queryOrganizationTypeList(organizationTypeVo));
    }

    /**
     * 查询所有组织类型
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectOrganizationTypeList")
    public Result selectOrganizationTypeList() throws Exception {
        return success(organizationTypeService.selectOrganizationTypeList());
    }

    /**
     * 根据ID查询组织类型
     */
    @RequestMapping(method = RequestMethod.GET, value = "findOrganizationTypeById/{pkOrganizationTypeId}")
    public Result findById(@PathVariable("pkOrganizationTypeId") String pkOrganizationTypeId) {
        return success(organizationTypeService.findById(pkOrganizationTypeId));
    }

    /**
     * 新增组织类型
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertOrganizationType")
    public Result insertOrganizationType(OrganizationTypeDto organizationTypeDto) throws Exception {
        return success(organizationTypeService.insertSelective(organizationTypeDto));
    }

    /**
     * 修改组织类型
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateOrganizationType")
    public Result updateOrganizationType(OrganizationTypeDto organizationTypeDto) throws Exception {
        return success(organizationTypeService.updateByPrimaryKeySelective(organizationTypeDto));
    }

    /**
     * 根据ID移除组织类型（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeOrganizationTypeById/{pkOrganizationTypeId}")
    public Result removeOrganizationTypeById(@PathVariable("pkOrganizationTypeId") String pkOrganizationTypeId) throws Exception {
        return success(organizationTypeService.removeByPrimaryKey(pkOrganizationTypeId));
    }

    /**
     * 根据ID移除组织类型（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrganizationTypeById/{pkOrganizationTypeId}")
    public Result deleteOrganizationTypeById(@PathVariable("pkOrganizationTypeId") String pkOrganizationTypeId) throws Exception {
        return success(organizationTypeService.deleteByPrimaryKey(pkOrganizationTypeId));
    }

    /**
     * 批量删除组织类型（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeOrganizationTypeBatch")
    public Result removeOrganizationTypeBatch(@RequestParam String[] pkOrganizationTypeIds) throws Exception {
        return success(organizationTypeService.removeOrganizationTypeBatch(pkOrganizationTypeIds));
    }

    /**
     * 批量删除组织类型（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrganizationTypeBatch")
    public Result deleteOrganizationTypeBatch(@RequestParam String[] pkOrganizationTypeIds) throws Exception {
        return success(organizationTypeService.deleteOrganizationTypeBatch(pkOrganizationTypeIds));
    }

}
