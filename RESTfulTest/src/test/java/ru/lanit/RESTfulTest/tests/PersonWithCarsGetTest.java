package ru.lanit.RESTfulTest.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.Settings;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class PersonWithCarsGetTest extends Assert {

    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private BodyChecker bodyChecker = new BodyChecker();
    private ResponseSetter responseSetter = new ResponseSetter();
    private Settings settings = new Settings();

    private String id;
    private Integer expected;
    private String bodyExpected;

    public PersonWithCarsGetTest(){}

    public PersonWithCarsGetTest(String id, Integer expected, String bodyExpected){
        this.id = id;
        this.expected = expected;
        this.bodyExpected = bodyExpected;
    }

    @BeforeTest
    public void setup(){
        settings.setup();
    }

    @Test(description = "GET")
    public void getPersonWithCarsTest(){
        Response response = responseSetter.get("/personwithcars?personid="+id);

        if(id!=null && expected!=null && bodyExpected!=null) {
            int code = response.getStatusCode();
            String body = response.asString();
            statusCodeChecker.check(code, expected);
            bodyChecker.check(body, bodyExpected);
        }
    }

//    private String getCar(Response response){
//        JSONObject jsonResponse = new JSONObject(response.asString());
//        JSONArray jsonArrayOfCars = new JSONArray(jsonResponse.getJSONArray("cars").toString());
//        String model = jsonArrayOfCars.getJSONObject(0).getString("model");
//        return model;
//    }
}
