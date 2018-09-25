package ru.lanit.RESTfulTest.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class PersonWithCarsGetTest extends Assert {

    private StatusCodeChecker statusCodeChecker = new StatusCodeChecker();
    private BodyChecker bodyChecker = new BodyChecker();
    private ResponseSetter responseSetter = new ResponseSetter();

    @Test(description = "GET")
    public void getPersonWithCarsTest(Long id, int expected, String bodyExpected){
        Response response = responseSetter.get("/personwithcars?personid="+id);

        int code = response.getStatusCode();
        String body = response.asString();
        statusCodeChecker.check(code, expected);
        bodyChecker.check(body, bodyExpected);
    }

//    private String getCar(Response response){
//        JSONObject jsonResponse = new JSONObject(response.asString());
//        JSONArray jsonArrayOfCars = new JSONArray(jsonResponse.getJSONArray("cars").toString());
//        String model = jsonArrayOfCars.getJSONObject(0).getString("model");
//        return model;
//    }
}
