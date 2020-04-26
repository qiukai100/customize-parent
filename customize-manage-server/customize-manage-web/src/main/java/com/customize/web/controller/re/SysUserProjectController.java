package com.customize.web.controller.re;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.re.SysUserProjectVo;
import com.customize.domain.dto.re.SysUserProjectDto;
import com.customize.service.service.re.ISysUserProjectService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 关联用户项目表 re_sys_user_project
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("re/sysUserProject")
public class SysUserProjectController extends BaseController {

    private final ISysUserProjectService sysUserProjectService;

    @Autowired
    public SysUserProjectController(ISysUserProjectService sysUserProjectService) throws Exception {
        this.sysUserProjectService = sysUserProjectService;
    }

    /**
     * 分页条件查询关联用户项目
     */
    @RequestMapping(method = RequestMethod.GET, value = "querySysUserProjectPage")
    public Result querySysUserProjectPage(SysUserProjectVo sysUserProjectVo) throws Exception {
        return success(sysUserProjectService.querySysUserProjectPage(sysUserProjectVo));
    }

    /**
     * 条件查询关联用户项目
     */
    @RequestMapping(method = RequestMethod.GET, value = "querySysUserProjectList")
    public Result querySysUserProjectList(SysUserProjectVo sysUserProjectVo) throws Exception {
        return success(sysUserProjectService.querySysUserProjectList(sysUserProjectVo));
    }

    /**
     * 查询所有关联用户项目
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectSysUserProjectList")
    public Result selectSysUserProjectList() throws Exception {
        return success(sysUserProjectService.selectSysUserProjectList());
    }

    /**
     * 根据ID查询关联用户项目
     */
    @RequestMapping(method = RequestMethod.GET, value = "findSysUserProjectById/{pkReUserProjectId}")
    public Result findById(@PathVariable("pkReUserProjectId") String pkReUserProjectId) {
        return success(sysUserProjectService.findById(pkReUserProjectId));
    }

    /**
     * 新增关联用户项目
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertSysUserProject")
    public Result insertSysUserProject(SysUserProjectDto sysUserProjectDto) throws Exception {
        return success(sysUserProjectService.insertSelective(sysUserProjectDto));
    }

    /**
     * 修改关联用户项目
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateSysUserProject")
    public Result updateSysUserProject(SysUserProjectDto sysUserProjectDto) throws Exception {
        return success(sysUserProjectService.updateByPrimaryKeySelective(sysUserProjectDto));
    }

    /**
     * 根据ID移除关联用户项目（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysUserProjectById/{pkReUserProjectId}")
    public Result removeSysUserProjectById(@PathVariable("pkReUserProjectId") String pkReUserProjectId) throws Exception {
        return success(sysUserProjectService.removeByPrimaryKey(pkReUserProjectId));
    }

    /**
     * 根据ID移除关联用户项目（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysUserProjectById/{pkReUserProjectId}")
    public Result deleteSysUserProjectById(@PathVariable("pkReUserProjectId") String pkReUserProjectId) throws Exception {
        return success(sysUserProjectService.deleteByPrimaryKey(pkReUserProjectId));
    }

    /**
     * 批量删除关联用户项目（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeSysUserProjectBatch")
    public Result removeSysUserProjectBatch(@RequestParam String[] pkReUserProjectIds) throws Exception {
        return success(sysUserProjectService.removeSysUserProjectBatch(pkReUserProjectIds));
    }

    /**
     * 批量删除关联用户项目（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSysUserProjectBatch")
    public Result deleteSysUserProjectBatch(@RequestParam String[] pkReUserProjectIds) throws Exception {
        return success(sysUserProjectService.deleteSysUserProjectBatch(pkReUserProjectIds));
    }

}
