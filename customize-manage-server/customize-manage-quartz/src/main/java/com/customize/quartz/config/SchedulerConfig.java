package com.customize.quartz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulerConfig {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DruidDataSource dataSource) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setSchedulerName("CustomizeScheduler");
        // 启动延时
        factoryBean.setStartupDelay(1);
        factoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 每次启动重写任务
        factoryBean.setOverwriteExistingJobs(true);
        // 自动启动
        factoryBean.setAutoStartup(true);
        return factoryBean;
    }
}
