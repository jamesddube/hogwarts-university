package com.jamesdube.subjectservice.config;

import com.jamesdube.subjectservice.api.config.ApiConfig;
import com.jamesdube.subjectservice.business.config.BusinessConfig;
import com.jamesdube.subjectservice.data.config.DataConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({ApiConfig.class, BusinessConfig.class, DataConfig.class})
@ComponentScan(basePackages = "com.jamesdube.subjectservice")
public class AppConfig {
}
