package com.customize.generator;

import com.customize.generator.constants.Constants;
import com.customize.generator.util.VelocityUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GeneratorApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        VelocityUtils.initVelocity(Constants.UTF8);
    }
}
