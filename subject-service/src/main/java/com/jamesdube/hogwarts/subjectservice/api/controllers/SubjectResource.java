package com.jamesdube.hogwarts.subjectservice.api.controllers;

import com.jamesdube.hogwarts.subjectservice.api.response.Response;
import com.jamesdube.hogwarts.subjectservice.api.response.SubjectListResponse;
import com.jamesdube.hogwarts.subjectservice.api.response.SubjectResponse;
import com.jamesdube.hogwarts.subjectservice.business.service.SubjectService;
import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import com.jamesdube.hogwarts.subjectservice.api.request.SubjectRequest;
import com.jamesdube.hogwarts.subjectservice.utils.SubjectWrapper;
import com.jamesdube.hogwarts.subjectservice.utils.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static com.jamesdube.hogwarts.subjectservice.utils.ResponseConvertor.convert;
import static com.jamesdube.hogwarts.subjectservice.utils.ResponseConvertor.convertToSubject;

@EnableWebMvc
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
                subjectRequest.getName(),subjectRequest.getType());

        subjectResponse = convert(subject);

        return ResponseEntity.status(201)
                .body(subjectResponse);
    }

    @GetMapping("subjects")
    public ResponseEntity<Response> index(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type){

        List<Subject> subjects =  subjectService.all(generateWrapper(code,name,type));

        SubjectListResponse subjectListResponse = convert(subjects);

        return ResponseEntity.status(200)
                .body(subjectListResponse);
    }

    @GetMapping("subjects/{id}")
    public ResponseEntity<Response> find(@PathVariable Long id){

        SubjectResponse subjectResponse = new SubjectResponse();

        Subject subject =  subjectService.find(id);

        if (subject == null) return ResponseEntity.status(404).body(Response.notFound());

        subjectResponse.setSubject(convertToSubject(subject));

        return ResponseEntity.status(200)
                .body(subjectResponse);
    }

    @PatchMapping("subjects/{id}")
    public ResponseEntity<Response> edit(@PathVariable Long id, @RequestBody SubjectRequest subjectRequest){

        SubjectResponse subjectResponse = new SubjectResponse();

        Subject subject =  subjectService.edit(id,subjectRequest.getCode(),subjectRequest.getName());

        return subject == null ? ResponseEntity.status(422).body(Response.status(422)) :
                ResponseEntity.status(204).body(Response.status(204));
    }

    private SubjectWrapper generateWrapper(String code, String name, String type) {
        try{
            return new SubjectWrapper(code,name,Type.valueOf(type));
        }
        catch (Exception e) {
            return new SubjectWrapper(code, name, null);
        }
    }

}
