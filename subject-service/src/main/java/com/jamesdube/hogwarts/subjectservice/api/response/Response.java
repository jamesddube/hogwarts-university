package com.jamesdube.hogwarts.subjectservice.api.response;

import lombok.Data;

@Data
public class Response {

    protected int status;

    protected String message;

    private static Response response;

    public static Response status(int status){
        getInstance().setStatus(status);
        return getInstance();
    }

    public static Response message(String message){
        getInstance().setMessage(message);
        return getInstance();
    }

    public static Response notFound() {
        getInstance().setStatus(404);
        return getInstance();
    }

    public static Response getInstance(){

        if(response == null) response = new Response();

        return response;
    }
}
