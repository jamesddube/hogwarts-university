package com.jamesdube.hogwarts.subjectservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Import({ApiConfig.class, BusinessConfig.class, DataConfig.class})
@ComponentScan(basePackages = "com.jamesdube.hogwarts.subjectservice")
public class AppConfig {
}
