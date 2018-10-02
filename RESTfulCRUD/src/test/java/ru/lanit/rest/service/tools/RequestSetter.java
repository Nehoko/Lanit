package ru.lanit.rest.service.tools;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class RequestSetter {

    public static RequestSpecification post(JSONObject requestBody){
        return RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toString());
    }
}
