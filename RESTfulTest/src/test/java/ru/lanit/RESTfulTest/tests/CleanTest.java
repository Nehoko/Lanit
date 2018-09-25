package ru.lanit.RESTfulTest.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class CleanTest{

    private BodyChecker bodyChecker = new BodyChecker();
    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private ResponseSetter responseSetter = new ResponseSetter();

    @Test(description = "GET")
    public void getRequest(int expected, String bodyExpected){

        Response response = responseSetter.get("/clear");
        int code = response.getStatusCode();
        String body = response.asString();

        statusCodeChecker.check(code, expected);
        bodyChecker.check(body, bodyExpected);
    }
}
