package ru.lanit.RESTfulTest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.RequestSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class PersonPostTest extends Assert {
    private BodyChecker bodyChecker = new BodyChecker();
    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private RequestSetter requestSetter = new RequestSetter();

    @Test(description = "POST")
    public void postPersonTest(JSONObject requestBody, int expected, String bodyExpected){

        RequestSpecification request = requestSetter.post(requestBody);
        Response response = request.post("/person");

        String body = response.asString();
        int code = response.getStatusCode();

        statusCodeChecker.check(code, expected);
        bodyChecker.check(body, bodyExpected);
    }

}
