package com.jamesdube.hogwarts.subjectservice;

import com.google.gson.Gson;

public class TestHelper {

    public static Gson Gson = new Gson();

    public static String toJson(Object o){
        return Gson.toJson(o);
    }



}
