package com.jamesdube.subjectservice.api.response;

import lombok.Data;

@Data
public class SubjectResponse extends Response {

    private String code;

    private String name;
}
