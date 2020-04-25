package com.customize.activity.activiti.config;

import com.customize.activity.activiti.utils.FunctionOrgService;
import com.customize.activity.activiti.utils.IdGenerator;
import com.customize.activity.listeners.takeLeave.ApprovalListeners;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.deploy.Deployer;
import org.activiti.engine.impl.rules.RulesDeployer;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ActivityConfig {

    private final DataSource dataSource;
    private final PlatformTransactionManager platformTransactionManager;

    @Autowired
    public ActivityConfig(DataSource dataSource, PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.platformTransactionManager = platformTransactionManager;
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(ApplicationContext context) {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setTransactionManager(platformTransactionManager);
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate("true");
        configuration.setDbIdentityUsed(false);
        configuration.setAsyncExecutorActivate(true);
        configuration.setIdGenerator(new IdGenerator());
        RulesDeployer rulesDeployer=new RulesDeployer();
        List<Deployer> customPostDeployers=new ArrayList<>();
        customPostDeployers.add(rulesDeployer);
        configuration.setCustomPostDeployers(customPostDeployers);
        Map<Object, Object> map=new HashMap<>();
//        map.put("fn", new FunctionOrgService());// 加载自定义函数
        map.put("approvalListeners", context.getBean(ApprovalListeners.class));
        configuration.setBeans(map);
        return configuration;
    }

    @Bean
    public ProcessEngineFactoryBean processEngine(ApplicationContext context) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration(context));
        return processEngineFactoryBean;
    }


    @Bean
    public RepositoryService repositoryService(ApplicationContext context) throws Exception {
        return processEngine(context).getObject().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(ApplicationContext context) throws Exception {
        return processEngine(context).getObject().getRuntimeService();
    }

    @Bean
    public TaskService taskService(ApplicationContext context) throws Exception {
        return processEngine(context).getObject().getTaskService();
    }

    @Bean
    public HistoryService historyService(ApplicationContext context) throws Exception {
        return processEngine(context).getObject().getHistoryService();
    }
}
