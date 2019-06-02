package com.jamesdube.hogwarts.subjectservice.data.domain;

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

    public Subject(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Subject(){}
}
