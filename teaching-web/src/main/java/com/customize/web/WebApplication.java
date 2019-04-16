package com.customize.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * EnableAsync 启动异步方法注解
 * EntityScan 扫描jpa实体注解
 * MapperScan 扫描mybatis mapper
 * EnableEurekaClient 表明eureka客户端
 * EnableJpaRepositories 启动jpa repository 注解
 * ComponentScan 扫描spring mvc基本注解
 */
@EnableAsync
@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = {"com.customize.domain.entity"})
@MapperScan(basePackages = {"com.customize.mybatis.mapper"})
@EnableJpaRepositories(basePackages = {"com.customize.jpa.repository"})
@ComponentScan(basePackages = {
        "com.customize.web",
        "com.customize.service",
        "com.customize.component",
        "com.customize.redis"
})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
