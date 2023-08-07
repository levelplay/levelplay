package com.level.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableConfigurationProperties
@EnableAsync
@ComponentScan({"com.level.play.*"})
public class LevelPlayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LevelPlayApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LevelPlayApplication.class);
    }
}
