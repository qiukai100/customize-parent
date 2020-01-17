package com.customize.manage.controller.sys;

import com.customize.manage.core.BaseController;
import com.customize.manage.core.Result;
import com.customize.manage.entity.sys.SysJob;
import com.customize.manage.service.SysJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.customize.manage.core.Result.success;

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

    @RequestMapping(method = RequestMethod.POST, value = "insertJob")
    public Result insertJob(SysJob sysJob) {
        return success(sysJobService.insertSelective(sysJob));
    }

    @RequestMapping(method = RequestMethod.GET, value = "findById/{id}")
    public Result findById(@PathVariable("id") String id) {
        return success(sysJobService.findById(id));
    }
}
