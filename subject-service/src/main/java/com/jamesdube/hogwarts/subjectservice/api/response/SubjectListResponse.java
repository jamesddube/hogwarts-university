package com.jamesdube.hogwarts.subjectservice.api.response;

import lombok.Data;

import java.util.List;

@Data
public class SubjectListResponse extends Response {

    List<Subject> subjects;

}
