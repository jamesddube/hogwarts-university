package com.jamesdube.subjectservice.business.service;

import com.jamesdube.subjectservice.data.domain.Subject;
import com.jamesdube.subjectservice.data.repository.SubjectRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject create(String code, String name){

        Subject newSubject = new Subject(
                code,name);

        Subject createdSubject = subjectRepository.save(newSubject);

        return createdSubject;

    }

}
