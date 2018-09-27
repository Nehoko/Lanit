package ru.lanit.RESTfulTest.parts;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.RequestSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class CarPost {

    public static void postCarTest(JSONObject car, Integer expected, String bodyExpected){

        RequestSpecification request = RequestSetter.post(car);

        Response response = request.post("/car");

        int code = response.getStatusCode();
        String body = response.asString();

        if(expected!=null && bodyExpected!=null) {
            StatusCodeChecker.check(code, expected);
            BodyChecker.check(body, bodyExpected);
        }else if (expected!=null){
            StatusCodeChecker.check(code, expected);
        }
    }
}
