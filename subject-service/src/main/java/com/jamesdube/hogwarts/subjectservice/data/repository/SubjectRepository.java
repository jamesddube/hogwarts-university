package com.jamesdube.hogwarts.subjectservice.data.repository;

import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
