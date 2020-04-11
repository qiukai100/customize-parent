package com.customize.activity.listeners.takeLeave;

import com.customize.activity.activiti.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;

@Slf4j
public class ApprovalListeners implements ExecutionListener {

    public Expression taskKey;

    @Override
    public void notify(DelegateExecution delegateExecution) {
        String key = taskKey.getExpressionText();
        log.debug("approvalListeners is run. key is {}", key);
        RuntimeService runtimeService = SpringUtils.getBean(RuntimeService.class);
        runtimeService.startProcessInstanceByKey(key);
        // 审核人集合
        /*List<String> approverList = Lists.newArrayList();
//        httpClient.selectAllUser(delegateTask.getAssignee());
        approverList.add("zhangsan");
        approverList.add("lisi");
        delegateExecution.setVariable("approverList", approverList);
        delegateExecution.setVariable("up", 0);
        delegateExecution.setVariable("down", 0);*/
    }
}
