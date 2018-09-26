package ru.lanit.RESTfulTest.parts;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.RequestSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public class PersonPost {

    public static void postPersonTest(JSONObject requestBody, Integer expected, String bodyExpected){

        RequestSpecification request = RequestSetter.post(requestBody);
        Response response = request.post("/person");

        String body = response.asString();
        int code = response.getStatusCode();

        if(requestBody!=null && expected!=null && bodyExpected!=null) {
            StatusCodeChecker.check(code, expected);
            BodyChecker.check(body, bodyExpected);
        }else if (requestBody!=null && expected!=null){
            StatusCodeChecker.check(code, expected);
        }
    }
}
