package com.customize.generator;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GeneratorApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
