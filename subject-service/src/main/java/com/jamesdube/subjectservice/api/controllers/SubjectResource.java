package com.jamesdube.subjectservice.api.controllers;

import com.jamesdube.subjectservice.api.request.SubjectRequest;
import com.jamesdube.subjectservice.business.service.SubjectService;
import com.jamesdube.subjectservice.data.domain.Subject;
import com.jamesdube.subjectservice.api.response.Response;
import com.jamesdube.subjectservice.api.response.SubjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectResource {

    private SubjectService subjectService;

    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("subjects")
    public ResponseEntity<Response> create(@RequestBody SubjectRequest subjectRequest){

        SubjectResponse subjectResponse = new SubjectResponse();

        Subject subject =  subjectService.create(subjectRequest.getCode(),
                subjectRequest.getName());

        subjectResponse.setCode(subject.getCode());
        subjectResponse.setName(subject.getName());

        return ResponseEntity.status(201)
                .body(subjectResponse);
    }


}
