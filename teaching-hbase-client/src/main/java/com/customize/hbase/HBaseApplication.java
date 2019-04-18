package com.customize.hbase;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.customize.hbase"
})
public class HBaseApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(HBaseApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
