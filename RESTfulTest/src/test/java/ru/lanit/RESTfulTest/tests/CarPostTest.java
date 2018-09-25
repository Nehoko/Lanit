package ru.lanit.RESTfulTest.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;
import ru.lanit.RESTfulTest.tools.RequestSetter;

public class CarPostTest {

    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private BodyChecker bodyChecker = new BodyChecker();
    private RequestSetter requestSetter = new RequestSetter();

    @Test(description = "POST")
    public void postCarTest(JSONObject car, int expected, String bodyExpected){
        JSONObject requestBody = car;

        RequestSpecification request = requestSetter.post(requestBody);

        Response response = request.post("/car");

        int code = response.getStatusCode();
        String body = response.asString();

        statusCodeChecker.check(code, expected);
        bodyChecker.check(body, bodyExpected);
    }

}
