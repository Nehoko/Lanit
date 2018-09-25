package ru.lanit.RESTfulTest.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.RequestSetter;
import ru.lanit.RESTfulTest.tools.Settings;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class PersonPostTest {
    private BodyChecker bodyChecker = new BodyChecker();
    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private RequestSetter requestSetter = new RequestSetter();
    private Settings settings = new Settings();

    private JSONObject requestBody;
    private Integer expected;
    private String bodyExpected;

    public PersonPostTest(){}

    public PersonPostTest(JSONObject requestBody, Integer expected, String bodyExpected){
        this.requestBody = requestBody;
        this.expected = expected;
        this.bodyExpected = bodyExpected;
    }

    @BeforeTest
    public void setup(){
        settings.setup();
    }

    @Test(description = "POST")
    public void postPersonTest(){

        RequestSpecification request = requestSetter.post(requestBody);
        Response response = request.post("/person");

        String body = response.asString();
        int code = response.getStatusCode();

        if(requestBody!=null && expected!=null && bodyExpected!=null) {
            statusCodeChecker.check(code, expected);
            bodyChecker.check(body, bodyExpected);
        }
    }

}
