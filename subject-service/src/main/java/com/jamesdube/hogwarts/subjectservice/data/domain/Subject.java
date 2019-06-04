package com.jamesdube.hogwarts.subjectservice.data.domain;

import com.jamesdube.hogwarts.subjectservice.utils.Type;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    public Subject(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Subject(Long id, String code, String name,Type type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Subject(String code, String name, Type type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public Subject(){}
}
