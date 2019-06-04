package com.jamesdube.hogwarts.subjectservice.utils;

import com.jamesdube.hogwarts.subjectservice.api.response.SubjectListResponse;
import com.jamesdube.hogwarts.subjectservice.api.response.SubjectResponse;
import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public class ResponseConvertor {

    public static SubjectResponse convert(Subject subject){

        SubjectResponse subjectResponse = new SubjectResponse();

        subjectResponse.setSubject(convertToSubject(subject));

        return subjectResponse;
    }

    public static SubjectListResponse convert(List<Subject> subjects){

        SubjectListResponse subjectListResponse = new SubjectListResponse();
        subjectListResponse.setSubjects(new ArrayList<>());

        for(Subject subject : subjects){
            subjectListResponse.getSubjects()
                    .add(convertToSubject(subject));
        }

        return subjectListResponse;
    }

    public static com.jamesdube.hogwarts.subjectservice.api.response.Subject convertToSubject(Subject subject){
        com.jamesdube.hogwarts.subjectservice.api.response.Subject
                apiSubject = new com.jamesdube.hogwarts.subjectservice.api.response.Subject();

        apiSubject.setCode(subject.getCode());
        apiSubject.setName(subject.getName());
        apiSubject.setType(subject.getType().getValue());

        return apiSubject;
    }
}
