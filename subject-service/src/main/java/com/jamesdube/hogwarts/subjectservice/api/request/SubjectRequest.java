package com.jamesdube.hogwarts.subjectservice.api.request;

import com.jamesdube.hogwarts.subjectservice.utils.Type;
import lombok.Data;

@Data
public class SubjectRequest {

    private Long id;

    private String code;

    private String name;

    private Type type;

    public SubjectRequest() {
    }

    public SubjectRequest(Long id, String code, String name, Type type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
    }
}
