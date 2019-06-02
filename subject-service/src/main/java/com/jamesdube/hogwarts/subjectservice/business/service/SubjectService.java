package com.jamesdube.hogwarts.subjectservice.business.service;

import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import com.jamesdube.hogwarts.subjectservice.data.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Subject> all(){
        return subjectRepository.findAll();

    }

    public Subject find(Long id) {

        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        return optionalSubject.orElse(null);
    }
}
