package com.customize.activity.activiti.config;

import com.customize.activity.activiti.factory.GroupEntityManagerFactory;
import com.customize.activity.activiti.factory.UserEntityManagerFactory;
import com.customize.activity.activiti.utils.IdGenerator;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ActivityConfig implements ProcessEngineConfigurationConfigurer {

    private final UserEntityManagerFactory userEntityManagerFactory;

    private final GroupEntityManagerFactory groupEntityManagerFactory;

    @Autowired
    public ActivityConfig(UserEntityManagerFactory userEntityManagerFactory, GroupEntityManagerFactory groupEntityManagerFactory) {
        this.userEntityManagerFactory = userEntityManagerFactory;
        this.groupEntityManagerFactory = groupEntityManagerFactory;
    }

    @Override
    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
        // 设置流程ID的生成方式
        processEngineConfiguration.setIdGenerator(new IdGenerator());
        //自定义用户和组
        List<SessionFactory> customSessionFactories = new ArrayList<>();
        customSessionFactories.add(userEntityManagerFactory);
        customSessionFactories.add(groupEntityManagerFactory);
        processEngineConfiguration.setCustomSessionFactories(customSessionFactories);
    }
}
