package ru.lanit.RESTfulTest.parts;

import io.restassured.response.Response;
import org.testng.Assert;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class PersonWithCarsGet extends Assert {

    public static void getTest(String id, Integer expected, String bodyExpected){
        Response response = ResponseSetter.get("/personwithcars?personid="+id);

        int code = response.getStatusCode();
        String body = response.asString();

        if(expected!=null && bodyExpected!=null) {
            StatusCodeChecker.check(code, expected);
            BodyChecker.check(body, bodyExpected);
        }else if(expected!=null){
            StatusCodeChecker.check(code, expected);
        }
    }

//    private String getCar(Response response){
//        JSONObject jsonResponse = new JSONObject(response.asString());
//        JSONArray jsonArrayOfCars = new JSONArray(jsonResponse.getJSONArray("cars").toString());
//        String model = jsonArrayOfCars.getJSONObject(0).getString("model");
//        return model;
//    }
}
