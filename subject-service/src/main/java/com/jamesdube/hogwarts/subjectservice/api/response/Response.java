package com.jamesdube.hogwarts.subjectservice.api.response;

import lombok.Data;

@Data
public class Response {

    protected int status;

    protected String message;

    public static Response notFound() {
        Response response = new Response();
        response.setStatus(404);
        return response;
    }
}
