package com.customize.manage;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableFeignClients
@SpringCloudApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}