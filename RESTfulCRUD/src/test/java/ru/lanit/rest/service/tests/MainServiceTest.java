package ru.lanit.rest.service.tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.lanit.rest.service.tools.ResponseSetter;
import ru.lanit.rest.service.tools.Settings;

import static org.junit.Assert.*;

public class MainServiceTest extends Assert {

    @Before
    public void beforeTest(){
        Settings.setup();
    }

    @Test
    public void getStatistics() {
        Response response = ResponseSetter.get("/statistics");

        int code = response.getStatusCode();
        String body = response.asString();

        String expectedBody = "Statistics{personcount=0, carcount=0, uniquevendorcount=0}";
        assertEquals(200, code);
        assertEquals(expectedBody,body);

    }

    @Test
    public void clearAll() {
        Response response = ResponseSetter.get("/clear");

        int code = response.getStatusCode();
        String body = response.asString();
        assertEquals(code, 200);
        assertEquals(body,"");
    }
}