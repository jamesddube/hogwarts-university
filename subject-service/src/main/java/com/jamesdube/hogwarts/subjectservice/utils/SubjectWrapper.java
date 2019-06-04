package com.jamesdube.hogwarts.subjectservice.utils;

import lombok.Data;

@Data
public class SubjectWrapper {

    private Long id;

    private String code;

    private String name;

    private Type type;

    public SubjectWrapper() {
    }

    public SubjectWrapper(String code, String name, Type type) {
        super();
        this.code = code;
        this.name = name;
        this.type = type;
    }
}
