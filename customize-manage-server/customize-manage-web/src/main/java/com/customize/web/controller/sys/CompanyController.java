package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.CompanyVo;
import com.customize.domain.dto.sys.CompanyDto;
import com.customize.service.service.sys.ICompanyService;

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
@RequestMapping("sys/company")
@Api(value = "sys/company", description  = "公司管理接口")
public class CompanyController extends BaseController {

    private final ICompanyService companyService;

    @Autowired
    public CompanyController(ICompanyService companyService) throws Exception {
        this.companyService = companyService;
    }

    @ApiOperation("分页条件查询公司")
    @RequestMapping(method = RequestMethod.GET, value = "queryCompanyPage")
    public Result queryCompanyPage(CompanyVo companyVo) throws Exception {
        return success(companyService.queryCompanyPage(companyVo));
    }

    @ApiOperation("条件查询公司")
    @RequestMapping(method = RequestMethod.GET, value = "queryCompanyList")
    public Result queryCompanyList(CompanyVo companyVo) throws Exception {
        return success(companyService.queryCompanyList(companyVo));
    }

    @ApiOperation("查询所有公司")
    @RequestMapping(method = RequestMethod.GET, value = "selectCompanyList")
    public Result selectCompanyList() throws Exception {
        return success(companyService.selectCompanyList());
    }

    @ApiOperation("根据ID查询公司")
    @RequestMapping(method = RequestMethod.GET, value = "findCompanyById/{pkCompanyId}")
    public Result findById(@PathVariable("pkCompanyId") String pkCompanyId) {
        return success(companyService.findById(pkCompanyId));
    }

    @ApiOperation("新增公司")
    @RequestMapping(method = RequestMethod.POST, value = "insertCompany")
    public Result insertCompany(CompanyDto companyDto) throws Exception {
        return success(companyService.insertSelective(companyDto));
    }

    @ApiOperation("修改公司")
    @RequestMapping(method = RequestMethod.PUT, value = "updateCompany")
    public Result updateCompany(CompanyDto companyDto) throws Exception {
        return success(companyService.updateByPrimaryKeySelective(companyDto));
    }

    @ApiOperation("根据ID移除公司（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeCompanyById/{pkCompanyId}")
    public Result removeCompanyById(@PathVariable("pkCompanyId") String pkCompanyId) throws Exception {
        return success(companyService.removeByPrimaryKey(pkCompanyId));
    }

    @ApiOperation("根据ID移除公司（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCompanyById/{pkCompanyId}")
    public Result deleteCompanyById(@PathVariable("pkCompanyId") String pkCompanyId) throws Exception {
        return success(companyService.deleteByPrimaryKey(pkCompanyId));
    }

    @ApiOperation("批量删除公司（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeCompanyBatch")
    public Result removeCompanyBatch(@RequestParam String[] pkCompanyIds) throws Exception {
        return success(companyService.removeCompanyBatch(pkCompanyIds));
    }

    @ApiOperation("批量删除公司（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCompanyBatch")
    public Result deleteCompanyBatch(@RequestParam String[] pkCompanyIds) throws Exception {
        return success(companyService.deleteCompanyBatch(pkCompanyIds));
    }

}
