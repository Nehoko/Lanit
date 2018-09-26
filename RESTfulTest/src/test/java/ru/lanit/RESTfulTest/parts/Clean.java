package ru.lanit.RESTfulTest.parts;

import io.restassured.response.Response;
import ru.lanit.RESTfulTest.tools.BodyChecker;
import ru.lanit.RESTfulTest.tools.ResponseSetter;
import ru.lanit.RESTfulTest.tools.StatusCodeChecker;

public  class Clean {

    public static void getRequest(Integer expected, String bodyExpected){

        Response response = ResponseSetter.get("/clear");
        int code = response.getStatusCode();
        String body = response.asString();

        if(expected!=null && bodyExpected!=null) {
            StatusCodeChecker.check(code, expected);
            BodyChecker.check(body, bodyExpected);
        }
    }
}
