package ru.lanit.RESTfulTest.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class StatisticsTest{
    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private BodyChecker bodyChecker = new BodyChecker();
    private ResponseSetter responseSetter = new ResponseSetter();

    @Test(description = "GET")
    public void getStatisticsTest(int expected, String bodyExpected) {
        Response response = responseSetter.get("/statistics");

        int code = response.getStatusCode();
        String body = response.asString();

        statusCodeChecker.check(code, expected);
        bodyChecker.check(body,bodyExpected);

    }
}
