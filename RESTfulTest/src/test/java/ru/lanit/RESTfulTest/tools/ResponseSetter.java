package ru.lanit.RESTfulTest.tools;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseSetter {

    public Response get(String uri){
        return RestAssured
                .given()
                .log()
                .all()
                .get(uri);
    }
}
