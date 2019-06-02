package com.jamesdube.subjectservice.data.config;

import com.jamesdube.subjectservice.data.domain.DomainMarker;
import com.jamesdube.subjectservice.data.repository.RepositoryMarker;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = DomainMarker.class)
@EnableJpaRepositories(basePackageClasses = RepositoryMarker.class)
public class DataConfig {

}
