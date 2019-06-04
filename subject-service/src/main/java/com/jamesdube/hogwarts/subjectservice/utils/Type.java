package com.jamesdube.hogwarts.subjectservice.utils;

public enum Type {
    OLEVEL("OLEVEL"), ALEVEL("ALEVEL");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
