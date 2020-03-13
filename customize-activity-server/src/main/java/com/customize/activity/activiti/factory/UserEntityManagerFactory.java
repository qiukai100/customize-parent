package com.customize.activity.activiti.factory;

import com.customize.activity.service.UserEntityService;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityManagerFactory implements SessionFactory {

    private final UserEntityService userEntityService;

    @Autowired
    public UserEntityManagerFactory(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @Override
    public Class<?> getSessionType() {
        return UserEntityService.class;
    }

    @Override
    public Session openSession(CommandContext commandContext) {
        return (Session) userEntityService;
    }
}
