package com.customize.hbase;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
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
