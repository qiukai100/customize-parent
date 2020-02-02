package com.customize.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

@EnableAsync
@MapperScan(basePackages = {"com.customize.mybatis.mapper"})
@EnableFeignClients(basePackages = {"com.customize.feign.service"})
@SpringCloudApplication
@ComponentScan(basePackages = {"com.customize.web", "com.customize.service", "com.customize.feign", "com.customize.quartz"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
