package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.entity.sys.SysJob;
import com.customize.service.service.SysJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.customize.web.core.Result.success;

@Slf4j
@RestController
@RequestMapping("sys/job")
public class JobController extends BaseController {

    @Resource
    private SysJobService sysJobService;

    @RequestMapping(method = RequestMethod.GET, value = "queryJobList")
    public Result queryJobList(SysJob job,
                               @RequestParam(defaultValue = "0") Integer pageNum,
                               @RequestParam(defaultValue = "20") Integer pageSize) {
        return success(sysJobService.queryJobPage(job, pageNum, pageSize));
    }

    @RequestMapping(method = RequestMethod.GET, value = "selectAll")
    public Result selectAll() throws Exception {
        return success(sysJobService.selectAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "insertJob")
    public Result insertJob(SysJob sysJob) throws Exception {
        return success(sysJobService.insertSelective(sysJob));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateJobStatus")
    public Result updateJobStatus(@RequestParam String id, @RequestParam Boolean startUp) throws Exception {
        if (startUp) sysJobService.resumeJob(id);
        else sysJobService.pauseJob(id);
        return success();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteJob/{id}")
    public Result deleteJob(@PathVariable("id") String id) throws Exception {
        return success(sysJobService.deleteByPrimaryKey(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "findById/{id}")
    public Result findById(@PathVariable("id") String id) {
        return success(sysJobService.findById(id));
    }
}
