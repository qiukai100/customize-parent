package com.customize.activity.controller;

import com.customize.activity.service.ProcessService;
import com.customize.common.component.CommonResult;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("process")
public class ProcessController {

    private final RuntimeService runtimeService;

    private final ProcessService processService;

    private final TaskService taskService;

    @Autowired
    public ProcessController(RuntimeService runtimeService, ProcessService processService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.processService = processService;
        this.taskService = taskService;
    }

    @PostMapping("startProcessInstance/{processDefinitionKey}")
    public CommonResult startProcessInstance(@PathVariable String processDefinitionKey, @RequestParam String userId) {
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("userId", userId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
        log.debug("流程已启动！用户ID：{} 流程实例ID：{} 流程定义ID：{}", userId, processInstance.getId(), processInstance.getProcessDefinitionId());
        return CommonResult.success();
    }

    @PostMapping("completeTask/{taskId}")
    public CommonResult completeTask(@PathVariable String taskId, @RequestBody Map<String, Object> args) {
        taskService.complete(taskId, args);
        return CommonResult.success();
    }

    @GetMapping("selectTaskByUser")
    public CommonResult selectTaskByUser(@RequestParam String userId) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(userId).list();
        List<Map<String, Object>> result = Lists.newArrayList();
        list.forEach(task -> {
            Map<String, Object> map = Maps.newHashMap();
            map.put("taskId", task.getId());
            map.put("taskName", task.getName());
            map.put("createTime", task.getCreateTime());
            map.put("assignee", task.getAssignee());
            map.put("processInstanceId", task.getProcessInstanceId());
            map.put("executionId", task.getExecutionId());
            map.put("processDefinitionId", task.getProcessDefinitionId());
            result.add(map);
        });
        return CommonResult.success(result);
    }

    @GetMapping("showProcessImg/{processInstanceId}")
    public void showProcessImg(@PathVariable String processInstanceId, HttpServletResponse response) {
        try {
            processService.getFlowImgByInstanceId(processInstanceId, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
