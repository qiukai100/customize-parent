package com.customize.activity.activiti.factory;

import com.customize.activity.service.GroupEntityService;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupEntityManagerFactory implements SessionFactory {

    private final GroupEntityService groupEntityService;

    @Autowired
    public GroupEntityManagerFactory(GroupEntityService groupEntityService) {
        this.groupEntityService = groupEntityService;
    }

    @Override
    public Class<?> getSessionType() {
        return GroupEntityService.class;
    }

    @Override
    public Session openSession(CommandContext commandContext) {
        return (Session) groupEntityService;
    }
}
