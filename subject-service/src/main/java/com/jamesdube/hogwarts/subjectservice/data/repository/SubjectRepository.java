package com.jamesdube.hogwarts.subjectservice.data.repository;

import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubjectRepository extends JpaRepository<Subject, Long>, JpaSpecificationExecutor<Subject> {
}
