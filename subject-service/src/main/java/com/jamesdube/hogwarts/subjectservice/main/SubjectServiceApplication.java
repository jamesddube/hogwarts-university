package com.jamesdube.hogwarts.subjectservice.main;

import com.jamesdube.hogwarts.subjectservice.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@SpringBootApplication
public class SubjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectServiceApplication.class, args);
	}

}
