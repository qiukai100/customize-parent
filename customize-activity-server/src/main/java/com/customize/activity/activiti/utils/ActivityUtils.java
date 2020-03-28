package com.customize.activity.activiti.utils;

import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.*;

import java.util.List;

public class ActivityUtils {

    private static ProcessEngine getProcessEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }

    private static RepositoryService getRepositoryService() {
        return getProcessEngine().getRepositoryService();
    }

    private static TaskService getTaskService() {
        return getProcessEngine().getTaskService();
    }

    private static RuntimeService getRuntimeService() {
        return getProcessEngine().getRuntimeService();
    }

    private static HistoryService getHistoryService() {
        return getProcessEngine().getHistoryService();
    }

    private static IdentityService getIdentityService() {
        return getProcessEngine().getIdentityService();
    }

    /**
     * 创建任务节点
     * 多人审批
     */
    public static UserTask createUsersTask(String id, String name, List<String> assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setCandidateUsers(assignee);
        return userTask;
    }

    /**
     * 创建任务节点
     * 单人审批
     */
    public static UserTask createUserTask(String id, String name, String assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;
    }

    /**
     * 连线
     *
     * @param from
     * @param to
     * @return
     */
    public static SequenceFlow createSequenceFlow(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }

    /**
     * 开始节点
     *
     * @return
     */
    public static StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        startEvent.setName("start");
        return startEvent;
    }

    /**
     * 结束节点
     *
     * @return
     */
    public static EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        endEvent.setName("end");
        return endEvent;
    }
}
