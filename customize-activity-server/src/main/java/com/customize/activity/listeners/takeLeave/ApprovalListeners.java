package com.customize.activity.listeners.takeLeave;

import com.customize.activity.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.*;
import org.springframework.stereotype.Service;

@Slf4j
@Service("approvalListeners")
public class ApprovalListeners {

    private Expression taskKey;

//    @Autowired
    private ProcessService processService;

    public void notify(DelegateExecution delegateExecution) {
        log.debug(taskKey.getExpressionText());
        log.debug(processService.toString());

        /*String key = taskKey.getExpressionText();
        log.debug("approvalListeners is run. key is {}", key);
        RuntimeService runtimeService = SpringUtils.getBean(RuntimeService.class);
        runtimeService.startProcessInstanceByKey(key);*/
        // 审核人集合
        /*List<String> approverList = Lists.newArrayList();
//        httpClient.selectAllUser(delegateTask.getAssignee());
        approverList.add("zhangsan");
        approverList.add("lisi");
        delegateExecution.setVariable("approverList", approverList);
        delegateExecution.setVariable("up", 0);
        delegateExecution.setVariable("down", 0);*/
    }

    public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }
}
