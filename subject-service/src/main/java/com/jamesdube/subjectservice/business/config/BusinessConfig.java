package com.jamesdube.subjectservice.business.config;

import com.jamesdube.subjectservice.business.service.SubjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jamesdube.subjectservice.business")
public class BusinessConfig {

}
