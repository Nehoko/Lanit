package ru.lanit.RESTfulTest.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.Settings;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;
import ru.lanit.RESTfulTest.tools.RequestSetter;

public class CarPostTest {

    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private BodyChecker bodyChecker = new BodyChecker();
    private RequestSetter requestSetter = new RequestSetter();
    private Settings settings = new Settings();

    private JSONObject car;
    private Integer expected;
    private String bodyExpected;

    public CarPostTest(){}

    public CarPostTest(JSONObject car, Integer expected, String bodyExpected){
        this.car = car;
        this.expected = expected;
        this.bodyExpected = bodyExpected;
    }

    @BeforeTest
    public void setup(){
        settings.setup();
    }

    @Test(description = "POST")
    public void postCarTest(){
        JSONObject requestBody = car;

        RequestSpecification request = requestSetter.post(requestBody);

        Response response = request.post("/car");

        int code = response.getStatusCode();
        String body = response.asString();


            statusCodeChecker.check(code, expected);
            bodyChecker.check(body, bodyExpected);

    }

}
