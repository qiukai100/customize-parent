package com.customize.activity.listeners.takeLeave;

import com.customize.activity.http.cfsc.HttpClient;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ApprovalListeners implements JavaDelegate {

    @Autowired
    private HttpClient httpClient;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.debug("approvalListeners is run.......");

        // 审核人集合
        List<String> approverList = Lists.newArrayList();
//        httpClient.selectAllUser(delegateTask.getAssignee());
        approverList.add("zhangsan");
        approverList.add("lisi");
        delegateExecution.setVariable("approverList", approverList);
        delegateExecution.setVariable("up", 0);
        delegateExecution.setVariable("down", 0);
    }
}
