package ru.lanit.RESTfulTest.tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.Settings;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class StatisticsTest{
    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private BodyChecker bodyChecker = new BodyChecker();
    private ResponseSetter responseSetter = new ResponseSetter();
    private Settings settings = new Settings();

    private Integer expected;
    private String bodyExpected;

    public StatisticsTest(){}

    public StatisticsTest(Integer expected, String bodyExpected){
        this.expected = expected;
        this.bodyExpected = bodyExpected;
    }

    @BeforeTest
    public void setup(){
        settings.setup();
    }

    @Test(description = "GET")
    public void getStatisticsTest() {
        Response response = responseSetter.get("/statistics");

        int code = response.getStatusCode();
        String body = response.asString();

        if(expected!=null && bodyExpected!=null) {
            statusCodeChecker.check(code, expected);
            bodyChecker.check(body, bodyExpected);
        }
    }
}
