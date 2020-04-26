package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.ProjectVo;
import com.customize.domain.dto.sys.ProjectDto;
import com.customize.service.service.sys.IProjectService;

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
@RequestMapping("sys/project")
@Api(value = "sys/project", description  = "项目管理接口")
public class ProjectController extends BaseController {

    private final IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) throws Exception {
        this.projectService = projectService;
    }

    @ApiOperation("分页条件查询项目")
    @RequestMapping(method = RequestMethod.GET, value = "queryProjectPage")
    public Result queryProjectPage(ProjectVo projectVo) throws Exception {
        return success(projectService.queryProjectPage(projectVo));
    }

    @ApiOperation("条件查询项目")
    @RequestMapping(method = RequestMethod.GET, value = "queryProjectList")
    public Result queryProjectList(ProjectVo projectVo) throws Exception {
        return success(projectService.queryProjectList(projectVo));
    }

    @ApiOperation("查询所有项目")
    @RequestMapping(method = RequestMethod.GET, value = "selectProjectList")
    public Result selectProjectList() throws Exception {
        return success(projectService.selectProjectList());
    }

    @ApiOperation("根据ID查询项目")
    @RequestMapping(method = RequestMethod.GET, value = "findProjectById/{pkProjectId}")
    public Result findById(@PathVariable("pkProjectId") String pkProjectId) {
        return success(projectService.findById(pkProjectId));
    }

    @ApiOperation("新增项目")
    @RequestMapping(method = RequestMethod.POST, value = "insertProject")
    public Result insertProject(ProjectDto projectDto) throws Exception {
        return success(projectService.insertSelective(projectDto));
    }

    @ApiOperation("修改项目")
    @RequestMapping(method = RequestMethod.PUT, value = "updateProject")
    public Result updateProject(ProjectDto projectDto) throws Exception {
        return success(projectService.updateByPrimaryKeySelective(projectDto));
    }

    @ApiOperation("根据ID移除项目（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeProjectById/{pkProjectId}")
    public Result removeProjectById(@PathVariable("pkProjectId") String pkProjectId) throws Exception {
        return success(projectService.removeByPrimaryKey(pkProjectId));
    }

    @ApiOperation("根据ID移除项目（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProjectById/{pkProjectId}")
    public Result deleteProjectById(@PathVariable("pkProjectId") String pkProjectId) throws Exception {
        return success(projectService.deleteByPrimaryKey(pkProjectId));
    }

    @ApiOperation("批量删除项目（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeProjectBatch")
    public Result removeProjectBatch(@RequestParam String[] pkProjectIds) throws Exception {
        return success(projectService.removeProjectBatch(pkProjectIds));
    }

    @ApiOperation("批量删除项目（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProjectBatch")
    public Result deleteProjectBatch(@RequestParam String[] pkProjectIds) throws Exception {
        return success(projectService.deleteProjectBatch(pkProjectIds));
    }

}
