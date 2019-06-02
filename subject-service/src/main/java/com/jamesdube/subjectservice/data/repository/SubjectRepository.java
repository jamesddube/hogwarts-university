package com.jamesdube.subjectservice.data.repository;

import com.jamesdube.subjectservice.data.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
